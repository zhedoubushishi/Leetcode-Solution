import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int lineLength = 0;
        int startIndex = 0;

        for (int i = 0; i < words.length; i++) {
            if (lineLength + words[i].length() + i - startIndex <= maxWidth) {
                lineLength += words[i].length();
            } else {

                // process line

                if (i > 0) i--;

                if (i == startIndex) {
                    StringBuilder line = new StringBuilder();
                    line.append(words[startIndex]);
                    appendSpace(line, maxWidth - line.length());
                    res.add(line.toString());

                } else {

                    int averageSpace = (maxWidth - lineLength) / (i - startIndex);
                    int extraSpace = (maxWidth - lineLength) % (i - startIndex);
                    res.add(generateLine(words, startIndex, i, averageSpace, extraSpace, maxWidth));
                }
                lineLength = 0;
                startIndex = i + 1;
            }
        }

        // process last line
        StringBuilder lastLine = new StringBuilder();
        for (int i = startIndex; i < words.length; i++) {
            lastLine.append(words[i]);
            lastLine.append(" ");
        }
        lastLine.deleteCharAt(lastLine.length() - 1);
        appendSpace(lastLine, maxWidth - lastLine.length());
        res.add(lastLine.toString());

        return res;
    }


    private static String generateLine(String[] words, int start, int end, int averageSpace, int extraSpace, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            appendSpace(sb, averageSpace);
            if (extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }
        }
        sb.append(words[end]);

        appendSpace(sb, maxWidth - sb.length());

        return sb.toString();
    }


    private static void appendSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }




    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> res = fullJustify(words, 16);
        for (String s : res) {
            System.out.println(s);
        }

    }
}

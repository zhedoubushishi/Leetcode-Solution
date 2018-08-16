public class Leetcode38 {

    public static String countAndSay(int n) {

        String oldString = "1";
        StringBuilder ori = new StringBuilder('1');

        // 21
        while (--n >= 1) {
            char[] oldChars = oldString.toCharArray();
            StringBuilder next = new StringBuilder();

            int k;
            for (int i = 0; i < oldChars.length; i = k) {
                char curChar = oldChars[i];
                k = i + 1;
                while (k < oldChars.length && oldChars[k] == curChar) {
                    k++;
                }
                next.append((char)('0' + k - i));
                next.append(curChar);
            }

            oldString = next.toString();
        }

        return oldString;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}

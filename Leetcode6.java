package leetcode;

public class Leetcode6 {

    public static String convert2(String s, int nRows) {
        int length = s.length();
        if (length <= nRows || nRows == 1) return s;
        char[] chars = new char[length];
        int step = 2 * (nRows - 1);
        int count = 0;
        for (int i = 0; i < nRows; i++){
            int interval = step - 2 * i;
            for (int j = i; j < length; j += step){
                chars[count] = s.charAt(j);
                count++;
                if (interval < step && interval > 0
                        && j + interval < length && count <  length){
                    chars[count] = s.charAt(j + interval);
                    count++;
                }
            }
        }
        return new String(chars);
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            return null;
        }
        if (numRows == 1 || numRows > s.length()) {
            return s;
        }

        int k = 2 * numRows - 2;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        int row = 0;
        int col = 0;
        boolean isOdd = true;

        while (count < s.length()) {

            if (row == 0) {
                while (col < len) {
                    sb.append(s.charAt(col));
                    count++;
                    col += k;
                }
                row++;
                col = 0;
            }

            if (0 < row && row < numRows - 1) {

                if (col == 0) {
                    sb.append(s.charAt(row));
                    count++;
                    col++;
                    isOdd = true;
                } else {
                    if (isOdd) {
                        index = col * k - row;
                        isOdd = !isOdd;
                    } else {
                        index = col * k + row;
                        isOdd = !isOdd;
                        col++;
                    }

                    if (index < len) {
                        sb.append(s.charAt(index));
                        count++;
                    } else {
                        row++;
                        col = 0;
                    }
                }

            }

            if (row == numRows - 1) {
                while (col + row < len) {
                    sb.append(s.charAt(col + row));
                    count++;
                    col += k;
                }
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert2(s, 3));
    }

}

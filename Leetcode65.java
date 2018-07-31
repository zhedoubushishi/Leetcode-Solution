public class Leetcode65 {

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim();
        if (s.length() == 0) {
            return false;
        }

        int startIndex = 0;
        // '-' or '+'
        if (s.length() > 1) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                startIndex = 1;
            }
        }

        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'

        for (int i = startIndex; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (Character.isDigit(cur)) {
                num = true;
            }

            else if (cur == '.') {
                if (exp || dot) return false;
                dot = true;
            }

            else if (cur == 'e') {
                if (exp || num == false) return false;
                exp = true;
                num = false;
            }

            else if (cur == '+' || cur == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            }

            else {
                return false;
            }

        }

        return num;
    }
}

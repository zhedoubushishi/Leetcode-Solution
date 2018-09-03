import java.util.ArrayList;
import java.util.List;

class Leetcode93 {
    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        helper(s, res, new StringBuilder(), 1);

        return res;
    }


    private static void helper(String s,
                        List<String> res,
                        StringBuilder curIP,
                        int position) {
        if (position == 4) {
            if (valid(s)) {
                curIP.append('.' + s);
                res.add(curIP.toString());
            }
            return;
        }


        for (int i = 1; i <= 3 && (s.length() - i >= 4 - position); i++) {
            if (position == 1) {
                curIP.append(s.substring(0, i));
            } else {
                curIP.append('.' + s.substring(0, i));
            }

            helper(s.substring(i, s.length() - 1), res, curIP, position + 1);

            if (position == 1) {
                curIP.delete(0, curIP.length());
            } else {
                curIP.delete(curIP.length() - i - 1, curIP.length());
            }
        }

    }

    private static boolean valid(String s) {
        if (s.equals("")) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("255.255.11");
        sb.delete(sb.length() - 3, sb.length());
        System.out.println(sb.toString());
    }
}

import java.util.Stack;

public class Leetcode32 {

    // 0 1 2 3 4 5 6
    // ) ( ( ( ) ) ( ) )
    //   1 2
    // ( ( ) ( )
    public static int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            else {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String s = ")((())())";
        System.out.println(longestValidParentheses(s));
    }
}

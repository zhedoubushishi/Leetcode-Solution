import java.util.ArrayList;
import java.util.List;

public class Leetcode21 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        dfs(res, new StringBuilder(), n, n);
        return res;
    }

    private static void dfs(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            dfs(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
            //left++;
        }

        if (right > 0 && left < right) {
            sb.append(')');
            dfs(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
            //right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

}

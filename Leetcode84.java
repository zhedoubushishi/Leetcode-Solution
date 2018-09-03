import java.util.Stack;

public class Leetcode84 {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                //System.out.println("height: " + height);
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                //System.out.println("area: " + area);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("res: " + largestRectangleArea(new int[] {1, 5, 3}));
    }
}

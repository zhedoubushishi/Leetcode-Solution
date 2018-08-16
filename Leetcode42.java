public class Leetcode42 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;

        int leftheight = height[start];
        int rightheight = height[end];

        int res = 0;
        while (start + 1 < end) {
            if (height[start] < height[end]) {
                start++;
                if (leftheight > height[start]) {
                    res += leftheight - height[start];
                } else {
                    leftheight = height[start];
                }

            } else {
                end--;
                if (rightheight > height[end]) {
                    res += rightheight - height[end];
                } else {
                    rightheight = height[end];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}

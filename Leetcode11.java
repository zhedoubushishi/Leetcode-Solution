package leetcode;

public class Leetcode11 {

    public static int maxArea(int[] height) {

        int begin = 0;
        int end = height.length - 1;
        int max = 0;
        while(begin < end) {
            max = Math.max(max, Math.min(height[begin], height[end]) * (end - begin));
            if (height[begin] > height[end]) {
                end--;
            } else {
                begin++;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int[] list = {2, 1, 3, 2};
        System.out.println(maxArea(list));
    }
}

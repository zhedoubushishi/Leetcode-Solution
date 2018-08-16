package leetcode;

import java.util.Arrays;

public class Leetcode16 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;


            // -4, -1, 1, 2   -> 1
            while (start < end) {
                int curDiff = Math.abs(nums[start] + nums[end] + nums[i] - target);
                if (curDiff < diff) {
                    diff = curDiff;
                }

                if (nums[start] + nums[end] + nums[i] > target) {
                    end--;
                } else if (nums[start] + nums[end] + nums[i] < target) {
                    start++;
                } else {
                    return 0;
                }
            }

        }

        return diff;
    }

    public static void main(String[] args) {
        int[] list = {-1, 2, 1, -4};
        threeSumClosest(list, 1);
    }

}

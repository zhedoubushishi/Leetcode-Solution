public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int start = 0;
        int end = 0;
        int curMax = -1;

        while (end < nums.length - 1) {

            for (int i = start; i <= end; i++) {
                curMax = Math.max(curMax, i + nums[i]);
            }

            if (curMax == end) {
                return false;
            }

            end = curMax;
            start++;
        }

        return true;
    }
}

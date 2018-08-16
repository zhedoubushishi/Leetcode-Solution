public class Leetcode45 {

    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int start = 0, end = 0;
        int steps = 0;
        int maxJump = 0;

        while (true) {
            steps++;
            for (int i = start; i <= end; i++) {
                maxJump = Math.max(maxJump, nums[i] + i);
            }

            if (maxJump >= nums.length - 1) {
                break;
            }

            start = end + 1;
            end = maxJump;
        }

        return steps;
    }

}

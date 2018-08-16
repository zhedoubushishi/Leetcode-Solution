public class Leetcode41 {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        // 3,4,-1,1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }



    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,1}));
    }

}

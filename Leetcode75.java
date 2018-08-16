public class Leetcode75 {

    public void sortColors(int[] nums) {
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;

        // < pl is red
        // between pl & pr is white
        // > pr is blue

        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, i, pl);
                i++;
                pl++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, pr);
                pr--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

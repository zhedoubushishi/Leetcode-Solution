import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode31 {

    public static void nextPermutation(int[] nums) {
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                int tmp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = tmp;
                break;
            }
        }

        if (i == nums.length - 1) {
            for (int j = 0; j < nums.length / 2; j++) {
                int tmp = nums[j];
                nums[j] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[] {3, 2, 1});
    }

}

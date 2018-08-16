public class Leetcode33 {
    public static int search(int[] nums, int target) {
        /*
         *     /
         *    /
         *   /
         *  -----------
         *       /
         *      /
        */
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int split = nums[0];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target >= split) {
                if (nums[mid] < target && nums[mid] >= split) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] > target && nums[mid] < split) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = search(new int[] {5,1,3} ,3);
        System.out.println(res);
    }
}

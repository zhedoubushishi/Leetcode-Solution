public class Leetcode004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return (double)findKth(nums1, nums2, len / 2 + 1);
        }
        return (findKth(nums1, nums2, len / 2 + 1) + findKth(nums1, nums2, len / 2)) / 2.0;
    }

    public static int findKth(int[] nums1, int[] nums2, int k) {
        int start1 = 0;
        int start2 = 0;

        while (k > 0) {

            if (start1 >= nums1.length) return nums2[start2 + k - 1];
            if (start2 >= nums2.length) return nums1[start1 + k - 1];
            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int val1 = nums1.length <= start1 + k / 2 - 1 ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
            int val2 = nums2.length <= start2 + k / 2 - 1 ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];

            //if (val1 == val2) return val1;

            if (val1 < val2) {
                start1 += k / 2;
            } else {
                start2 += k / 2;
            }
            k -= k / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2};
        int[] num2 = new int[] {3, 4};
        findMedianSortedArrays(num1, num2);
    }
}

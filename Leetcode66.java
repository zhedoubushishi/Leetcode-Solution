public class Leetcode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                int[] res = digits.clone();
                res[i] += 1;
                for (int j = i + 1; j < digits.length; j++) {
                    res[j] = 0;
                }
                return res;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = 0;
        }

        return res;
    }
}

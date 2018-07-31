public class Leetcode60 {

    public static String getPermutation(int n, int k) {
        k--;
        int bit = n;
        StringBuilder res = new StringBuilder();

        boolean[] used = new boolean[n];

        while (bit > 0) {
            int splitRange = calFactor(bit - 1);
            res.append(getNUnsed(used, k / splitRange));
            k = k % splitRange;
            bit--;
        }

        return res.toString();
    }



    private static int calFactor(int n) {
        int res = 1;
        for (int i = n; i > 1; i--) {
            res = res * i;
        }
        return res;
    }

    private static int getNUnsed(boolean[] used, int n) {
        int i;
        for (i = 0; i < used.length; i++) {

            if (!used[i]) {
                n--;
                if (n < 0) {
                    break;
                }
            } else {
                continue;
            }
        }
        used[i] = true;
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}

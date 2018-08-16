package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode7 {

    public static int reverse(int x) {

        int reversed_n = 0;

        while (x != 0) {
            int temp = reversed_n * 10 + x % 10;
            x = x / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;

        /*List<Integer> digits = new ArrayList<>();

        while (x != 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        long res = 0;
        for (int i = 0; i < digits.size(); i++) {
            res = res * 10 + digits.get(i);
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;*/

    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}

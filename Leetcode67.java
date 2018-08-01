public class Leetcode67 {

    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }

        if (b.length() == 0) {
            return a;
        }

        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (pointerA >= 0 || pointerB >= 0) {
            int bitA = pointerA >= 0 ? Integer.parseInt(String.valueOf(a.charAt(pointerA))) : 0;
            int bitB = pointerB >= 0 ? Integer.parseInt(String.valueOf(b.charAt(pointerB))) : 0;

            int curBit = bitA + bitB + carry;
            if (curBit > 1) {
                curBit = curBit % 2;
                carry = 1;
            } else {
                carry = 0;
            }
            res.append(String.valueOf(curBit));

            pointerA--;
            pointerB--;
        }

        if (carry == 1) {
            res.append('1');
        }

        return res.reverse().toString();
    }
}

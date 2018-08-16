package leetcode;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occurred index

        int j = 0;
        int i = 0;
        int ans = 0;
        for (; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }

        return ans;
    }


    public static void main(String[] args) {
        Leetcode3 test = new Leetcode3();
        String input = "abcbc";
        System.out.println(test.lengthOfLongestSubstring(input));
    }
}
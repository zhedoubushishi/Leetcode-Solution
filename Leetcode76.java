public class Leetcode76 {

    public String minWindow(String Source, String Target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        initTargetHash(targethash, Target);
        int j = 0;

        for (int i = 0; i < Source.length(); i++) {

            while (!valid(sourcehash, targethash) && j < Source.length()) {
                sourcehash[Source.charAt(j)]++;
                j++;
            }

            if (ans > j - i) {
                ans = j - i;
                minStr = Source.substring(i ,j);
            }
            sourcehash[Source.charAt(i)]--;
        }

        return minStr;
    }

    private int initTargetHash(int[] targetHash, String Target) {
        int targetNum = 0;

        for (char c : Target.toCharArray()) {
            targetNum++;
            targetHash[c] ++;
        }

        return targetNum;
    }

    private boolean valid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (sourceHash[i] < targetHash[i]) {
                return false;
            }
        }
        return true;
    }


}

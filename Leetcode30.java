import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode30 {

    /*
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * Output: [0,9]
    */

    public static ArrayList<Integer> findSubstring(String s, String[] words) {

        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) {
            return res;
        }

        HashMap<String, Integer> toFind = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!toFind.containsKey(words[i])) {
                toFind.put(words[i], 1);
            } else {
                toFind.put(words[i], toFind.get(words[i]) + 1);
            }
        }

        HashMap<String, Integer> found = new HashMap<>();

        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - words.length * wordLength; i++){
            found.clear();
            int j;
            for (j = 0; j < words.length; j++) {
                int k = i + j * wordLength;
                String stub = s.substring(k, k + wordLength);
                if (!toFind.containsKey(stub)) break;

                if (!found.containsKey(stub)) {
                    found.put(stub, 1);
                } else {
                    found.put(stub, found.get(stub) + 1);
                }

                if (found.get(stub) > toFind.get(stub)) break;
            }

            if (j == words.length) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"bar", "foo"};
        System.out.println(findSubstring("barthefoobarman", words).toString());
    }

}

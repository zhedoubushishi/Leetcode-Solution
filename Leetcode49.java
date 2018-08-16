import java.util.*;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = String.valueOf(sc);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
                map.get(key).add(s);
            } else {
                map.get(key).add(s);
            }
        }

        return new ArrayList<>(map.values());
    }
}

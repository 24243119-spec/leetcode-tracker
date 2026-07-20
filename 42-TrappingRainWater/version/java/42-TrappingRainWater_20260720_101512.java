// Last updated: 7/20/2026, 10:15:12 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.HashMap;
4import java.util.List;
5import java.util.Map;
6
7class Solution {
8    public List<List<String>> groupAnagrams(String[] strs) {
9        if (strs == null || strs.length == 0) {
10            return new ArrayList<>();
11        }
12
13        Map<String, List<String>> map = new HashMap<>();
14
15        for (String s : strs) {
16            char[] chars = s.toCharArray();
17            Arrays.sort(chars);
18            String sortedKey = String.valueOf(chars);
19
20            map.putIfAbsent(sortedKey, new ArrayList<>());
21            map.get(sortedKey).add(s);
22        }
23
24        return new ArrayList<>(map.values());
25    }
26}
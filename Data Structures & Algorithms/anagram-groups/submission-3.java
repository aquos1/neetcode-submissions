class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tracker = new HashMap<>();

        for (String str : strs) {
            // sort
            // check if in map
            // if not, add to map.

            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if (!tracker.containsKey(sortedStr)) {
                tracker.put(sortedStr, new ArrayList<>());
            }
            tracker.get(sortedStr).add(str);
        }

        // at this point, we should have everything grouped / sorted.

        // returning answer string.
        List<List<String>> res = new ArrayList<>();
        for (List<String> ans : tracker.values()) {
            res.add(ans);
        }

        return res;
    }
}

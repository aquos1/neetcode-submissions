class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hm with sorted string -> anagrams, then we can just print the values()


        // input: strs = ["act","pots","tops","cat","stop","hat"]
        // output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        Map<String, List<String>> tracker = new HashMap<>();

        for (String str : strs) { // act, pots
            char[] arr = str.toCharArray(); 
            Arrays.sort(arr); // act, opst, opst -> bottleneck in runtime
            // worst case sort is n log n. 
            String sort = new String(arr);

            if (!tracker.containsKey(sort)) { //
                tracker.put(sort, new ArrayList<>()); // act -> [], opst -> []
            } 

            tracker.get(sort).add(str); // act -> [act], opst -> [pots, tops]
        }


        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : tracker.entrySet()) {
            ans.add(entry.getValue()); // shud be a list of stringd
        }


        //O(nlogn) sol, O(n) space cuz hashmap will have every unique str from strs. 

        return ans; 
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        // we store the last merged within a merged list.

        // then we compare last merged to each NEW interval within intervals.

        // if merge possible:
            // update the last merged one
        // if not poss:
            // just add it to merged list

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); // shud be in ascending order.

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (!(merged.size() == 0)) {
                // check if mergeable within here
                if (merged.get(merged.size() - 1)[1] >= interval[0]) {
                    // we can merge
                    int begin = merged.get(merged.size() - 1) [0];
                    merged.set(merged.size() - 1, new int [] {begin, Math.max(merged.get(merged.size() - 1)[1] , interval[1])});
                } else {
                    // we cannot merge.
                    merged.add(interval);
                }
            } else {
                merged.add(interval);
            }
        }
        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ans[i] = merged.get(i);
        }

        return ans;
    }
}

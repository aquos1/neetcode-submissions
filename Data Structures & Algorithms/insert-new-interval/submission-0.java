class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // add new interval in, sort, and then merge interval?
        // merge intervals,
        int[][] intervalsPlusOne = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            intervalsPlusOne[i] = intervals[i];
        }

        intervalsPlusOne[intervalsPlusOne.length - 1] = newInterval;
        Arrays.sort(intervalsPlusOne, (a, b) -> Integer.compare(a[0], b[0])); //ascending order sorted by start time. 


        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervalsPlusOne) {
            int start = interval[0];
            int end = interval[1];
            if (res.size() != 0 && res.get(res.size() - 1)[1] >= start) {
                // merge
                int endOfLast = res.get(res.size() - 1)[1];
                res.set(res.size() - 1, new int[] {res.get(res.size() - 1)[0], Math.max(endOfLast, end)}); // the last value
            } else {
                res.add(interval);
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}

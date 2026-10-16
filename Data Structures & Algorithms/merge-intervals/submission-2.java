class Solution {
    public int[][] merge(int[][] intervals) {
        //ascending order
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0]))); 
        
        // for (int[] i : intervals) System.out.println(i[0]); 
        List<int[]> ans = new ArrayList<>(); 
        ans.add(intervals[0]); 

        for (int[] interval : intervals) {
            int start = interval[0]; 
            int end = interval[1]; 
            // check if the last interval is valid after checking if the 
            // lastEnd is GREATER than the next start, then u can merge. 
            int lastEnd = ans.get(ans.size() - 1)[1]; 

            if (start <= lastEnd) {
                //merge
                ans.get(ans.size() - 1)[1] = Math.max(end, lastEnd); 
            } else {
                ans.add(new int[] {start, end}); 
            }
        }

        return ans.toArray(new int[ans.size()][]); 
    }
}

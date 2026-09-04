class Solution {
    int k; 
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> hm; 
    public int[] topKFrequent(int[] nums, int k) {
        this.k = k; 
        this.hm = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);  
            } else {
                hm.put(nums[i], hm.get(nums[i]) + 1); 
            }
        }

        // for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        //     System.out.println(entry.getKey()); 
        //     System.out.println(entry.getValue()); 
        // }
        //Given an integer array nums and an integer k, return the k most frequent elements within the array.

        // The test cases are generated such that the answer is always unique.

        // You may return the output in any order.

        //k most freq elements -> store arrays of length 2, [key, freq] in heap, sorted by freq -> so minheap by frequency. 
        this.pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //shud be minheap by freq. 
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            add(entry.getKey()); 
        }

        int[] ans = new int[k]; 

        for (int i = 0; i < k; i++) {
            // System.out.println(pq.peek()[1]); 
            ans[i] = pq.poll()[0];  
        }

        return ans; 
    }

     public void add(int num) {
        int freq = hm.get(num); 
        if (pq.contains(new int[] {num, freq})) return; //skipping values we have alr seen!
        if (pq.size() >= k) {
            //compare 
            if (pq.peek()[1] <= freq) {
                pq.poll(); 
                pq.offer(new int[] {num,freq}); 
            }
        } else {
            //jus add shi 
            pq.offer(new int[] {num, freq}); 
        }
    }
}

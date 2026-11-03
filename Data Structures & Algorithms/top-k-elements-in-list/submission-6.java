class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    public int[] topKFrequent(int[] nums, int k) {
        // via min heap 

        // min heap storing arrays
            // array has 2 spots
            // value, frequency
        //we will imp comparator for frequency where minHeap.
        //so when we offer and freq is bigger


        // so bigger 2nd index val comes first.

        List<int[]> list = new ArrayList<>(); 

        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            if (!hm.containsKey(num)) {
                hm.put(num,1);
            } else {
                hm.put(num, hm.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int[] sub = new int[2];
            sub[0] = entry.getKey();
            sub[1] = entry.getValue();
            list.add(sub);
        }

        for (int[] poss : list) {
            add(poss, k);
        }

        int s = pq.size();
        int[] ans = new int[k];
        for (int i = 0; i < s; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans; 
        
    }

    public void add(int[] list, int k) {
        if (pq.size() == k) {
            if (pq.peek()[1] < list[1]) {
                pq.poll();
                pq.offer(list);
            }
        } else {
            pq.offer(list);
        }
    }
}

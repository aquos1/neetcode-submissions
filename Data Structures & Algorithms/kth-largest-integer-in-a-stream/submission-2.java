class KthLargest {
    PriorityQueue<Integer> pq; 
    int k; 
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>(); 
        this.k = k; 
        for (int num : nums) {
            add(num); 
        }
    }
    
    public int add(int val) {
        //add a value and return the kth largest integer. 
        //can do minHeap with k values. 
        //until k values in the minheap -> we keep adding
        //if k values r there, if the value at pq.peek() is <= the value we r tryna add, pop and add it.
        //then return the minHeap.peek(); 

        if (pq.size() < k) {
            pq.offer(val); 
        } else {
            if (pq.peek() <= val) {
                pq.poll(); 
                pq.offer(val); 
            }
        }
        return pq.peek(); 
    }
}

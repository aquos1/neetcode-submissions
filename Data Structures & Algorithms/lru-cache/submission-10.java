class LRUCache {
    //key idea is whenever we get, the LRU changes. so the value we get needs to be put at the end of the cache. 
    //so it needs to get val in O(1), but also update pop da node and then repush it at the end in O(1). 
    //so we need an add and remove method. 
    //use doubly linked list and hashmap w values. so adding is O(1), and removing is O(1). 
     int capacity; 
    Map<Integer, ListNode> memo; 
    ListNode first; 
    ListNode last; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.memo = new HashMap<>(); 
        this.first = new ListNode(0, 0); 
        this.last = new ListNode(0, 0); 
        first.next = last; 
        last.prev = first; 
    }

    public void remove(ListNode curr) {
        //find it, and do next.next to skip it. 
        ListNode toRemove = memo.get(curr.key);
        ListNode p = toRemove.prev; 
        ListNode after = toRemove.next; 
        after.prev = p; 
        p.next = after; 
    }

    public void add(ListNode curr) {
        ListNode prev = last.prev; 
        prev.next = curr; 
        curr.prev = prev; 
        curr.next = this.last; 
        this.last.prev = curr; 
    }

    public int get(int key) { 
        //everytime we get a value, we "use it", so we need to put this value we jus got at the end of our list -> need easy access remove, add. 
        //(need to find nodes in o(1)) -> hashmap w key and the node it corresponds to? (o(1) search) 
        if (memo.containsKey(key)) {
            //remove, add to list and then jus return emmo
            ListNode toGet = memo.get(key); 
            remove(toGet); 
            add(toGet); 
            return memo.get(key).val; 
        }
        return -1; 

    }

    public void put(int key, int value) {
        //everytime we put something we are adding to the list either ways, so it has to go at the end ? 
        //if in hm, we update hm node with a new listnode and also add remove.
        //if not in hm, we need to add to hm and add to the end of the list (via get maybe?)
        if (memo.containsKey(key)) {
            ListNode toUpdate = memo.get(key); 
            remove(toUpdate); 
        }

        ListNode toAdd = new ListNode(key, value); 
        memo.put(key, toAdd); 
        add(toAdd); 

        if (memo.size() > capacity) {
            //remove the first val 
            ListNode front = first.next; 
            remove(front); 
            memo.remove(front.key); 
        }
    }



    public class ListNode {
        int key; 
        int val; 
        ListNode prev; 
        ListNode next; 

        public ListNode (int key, int val) {
            this.key = key; 
            this.val = val;  
        }
    }
}

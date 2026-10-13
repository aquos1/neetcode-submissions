class Twitter {
    int count; 
    Map<Integer, List<int[]>> tweetMap; 
    Map<Integer, Set<Integer>> followMap; 
    public Twitter() {
        count = 0; 
        tweetMap = new HashMap<>();
        followMap = new HashMap<>(); 
    }
    
    public void postTweet(int userId, int tweetId) {
        //user id has a new tweet with tweet id. 

        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>()); 
        }

        tweetMap.get(userId).add(new int[] {count--, tweetId}); 
    }
    
    public List<Integer> getNewsFeed(int userId) {

        //go thru followerId -> list of followees and take each followee 

            //for every followee see if pq exists in hm below
                //if pq exists

                //if pq doesnt exist
                    //init pq with mru from all followers. 

                //if pq exists then update it? global pq 

        //only from ppl u follow or u. 
        //tweet ids from most recent to least recent. 

        //hm with user id -> pq with top k tweet ids with the most recent at the top. 

        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        Set<Integer> people = new HashSet<>(); 
        people.add(userId);

        if (followMap.containsKey(userId)) {
            people.addAll(followMap.get(userId)); 
        }

        for (int person : people) {
            if (!tweetMap.containsKey(person)) {
                continue; // never tweeted
            }
            List<int[]> tweets = tweetMap.get(person); 
            int index = tweets.size() - 1; 

            int[] mrt = tweets.get(index); 
            
            minHeap.offer(new int [] {mrt[0] , mrt[1], person, index}); 
        }

        while (!minHeap.isEmpty() && result.size() < 10) {
            int[] top = minHeap.poll(); 
            int id = top[1];
            int owner = top[2];
            int index = top[3];

            result.add(id); 

            int olderIndex = index - 1;
            
            if (olderIndex >= 0) {
                int[] older = tweetMap.get(owner).get(olderIndex);
                minHeap.add(new int [] {older[0], older[1], owner, olderIndex});
            }
        }

        return result; 
    }
    
    public void follow(int followerId, int followeeId) {
        //follows followee

        //hm with followerId -> list of followees including yourself. 

        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>()); 
            followMap.get(followerId).add(followerId); 
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        //unfollows followee

        if (followMap.containsKey(followerId)) {
            if (followMap.get(followerId).contains(followeeId)) {
                Set<Integer> list = followMap.get(followerId); 
                list.remove(followeeId); 
            }
        }
    }
}

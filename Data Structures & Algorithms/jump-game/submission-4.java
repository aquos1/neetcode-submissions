class Solution {
    Boolean[] memo; 
    public boolean canJump(int[] nums) {
        //arr with nums include max jump from pos. 
        //return true if u can reach last index. 
        //could try every path, but is redundant
        //instead at each index, ask a question, can we reach the end from this position? 
        //if so, store true and also return true. 
        //at the end the first call shud return whtever is stored in oth index or starting value. 
        this.memo = new Boolean[nums.length]; 
        return dfs(nums, 0); 
    }

    public boolean dfs(int[] nums, int index) { //index = 0, 1, index. = 2, or 3. 
        //if we land on a 0 we r stuck r false 

        //Input: nums = [1,2,0,1,0]

        // Output: true


        if (index >= nums.length - 1) return true; 
        if (nums[index] == 0) return false; 

        if (memo[index] != null) return memo[index]; 

        //else if index >= num length - 1, r true

        //if memo at index == then return ts too 

        //otherwise take min of possible jumps and end of list via indexable position. 
        //bool variable that = downstream answer
        //bool = dfs(nums, index + i ) from ebery i in the loop 
        //loop for 1 <= min from above  

        int maxJumps = Math.min(nums[index], nums.length - (index + 1)); // maxJumps = 1, 2
        boolean canReach = false; 
        for (int i = 1; i <= maxJumps; i++) { //1, 2
            canReach = canReach || dfs(nums, index + i); //0 + i = 1 , can jump 1 or 2. 
        }

        memo[index]= canReach;
        return canReach; 
        //store in memo

        //return bool 
        

    }
}       

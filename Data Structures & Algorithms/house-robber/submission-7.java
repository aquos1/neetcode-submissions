class Solution {
    Map<Integer, Integer> memo = new HashMap<>(); 
    public int rob(int[] nums) {
        //key piece here is either we can rob crib or we can not rob crib
        //int rob = nums[index] + etc -> move two
        //int skip = etc -> move one

        //then compare via Max
        int globalMax = 0; 
        int localMax = dfs(nums, 0); 
        globalMax = Math.max(localMax, globalMax); 
        return globalMax; 
    }

    public int dfs(int[] nums, int index) {
        if (index >= nums.length) return 0; 

        if (memo.containsKey(index)) return memo.get(index); 

        int rob = 0; 
        rob += nums[index] + dfs(nums, index + 2); 
        int skip = 0; 
        skip += dfs(nums, index + 1); 
        
        memo.put(index, Math.max(rob, skip)); 

        return memo.get(index); 
    }
}

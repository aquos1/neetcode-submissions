class Solution {
    Map<Integer, Integer> memo = new HashMap<>(); 
    public int coinChange(int[] coins, int amount) {
        //dfs w memoization
        int minC = dfs(coins, amount);  
        if (minC == 1000000) return -1; 
        return minC; 
    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0) return 0; 
        if (memo.containsKey(amount)) return memo.get(amount); 
        
        int res = 1000000; 
        for (int coin : coins) {
            if (amount - coin < 0) continue; 
            //remaining is <= , so soFar + coin is valid
            int stepsToAnswer = 1 + dfs(coins, amount - coin); 
            res = Math.min(res, stepsToAnswer); 
        }

        memo.put(amount, res); 
        return res; 
    }   
}
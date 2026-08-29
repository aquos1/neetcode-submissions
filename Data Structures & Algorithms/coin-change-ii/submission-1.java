class Solution {
    int count = 0; 
    int[][] memo; 
    public int change(int amount, int[] coins) {
        //backtracking solution -> asking to return distinct combos that add up to amt
        this.memo = new int[coins.length + 1][amount + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1); 
        }
        return dfs(amount, coins, 0); 
    }

    public int dfs(int amount, int[] coins, int index) {
        if (amount == 0) {
            return 1; 
        }

        if (index >= coins.length) return 0; 

        if (memo[index][amount] != -1) return memo[index][amount]; 
        int res = 0;
        res += dfs(amount, coins, index + 1); 
        if (amount >= coins[index]) {
            res += dfs(amount - coins[index],coins, index); 
        }

        memo[index][amount] = res; 
        return memo[index][amount]; 
    }
}

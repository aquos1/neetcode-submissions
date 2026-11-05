class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] != -1) return memo[i];

        int oneStep = dfs(n, i + 1);
        int twoStep = dfs(n, i + 2);

        memo[i] = oneStep + twoStep;

        return memo[i];
    }
}

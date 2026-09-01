class Solution {
    public int numSquares(int n) { // 13
        int[] dp = new int[n + 1]; //1 to 13. 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; //   


        for (int i = 1; i <= n; i++) { //i == 4, 
            for (int j = 1; j * j <= i; j++) { //try 1 thru 16 as j
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); //dp[4] = min of dp[4] and dp[value reduced by square]
            }
        }
        return dp[n];
    }
}
class Solution {
    double[] dp; 
    public double new21Game(int n, int k, int maxPts) {

        //k is the cap or ceiling. she can gain 1 to maxPts. 

        //if she is at k or greater, then return the probabikity that she has N or fewer. 

        //find prob that alice has N or fewer pts at the end. 


        //k is always gonna be less than n?

        //math here can be out of all possible paths, which one was act resulted in total value < n.  -> success

        // success/ total attempts = return answer. 
        dp = new double[k]; 
        Arrays.fill(dp, -1.0); 
        double ans = dfs(n, k, maxPts, 0); 
        return ans; 

    }

    public double dfs(int lessThan, int ceiling, int maxPts, int currTotal) {
        if (currTotal >= ceiling) {
            if (currTotal <= lessThan) return 1.0; 
            return 0.0; 
        }

        if (dp[currTotal] != -1.0) return dp[currTotal]; 


        double prob = 0; 
        for (int i = 1; i <= maxPts; i++) {
            prob += dfs(lessThan, ceiling, maxPts, currTotal + i); 
        }


        dp[currTotal] = prob / maxPts; 
        return dp[currTotal];

    }

}
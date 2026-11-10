class Solution {
    // from every point
        // return the longest increasing path. 
        // via param, we can carry the prev value, 
        // if the curr val is > prev, 1 + dfs of everything else.
        // otherwise return 0. 
        // when we bubble ts back up at each point we compare
        // to whatever other paths were. 
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    // some sort of a memo for optimization
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        memo = new int[r][c];
        int gMax = 0;
        for (int d = 0; d < memo.length; d++) Arrays.fill(memo[d], -1);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int fromHere = dfs(matrix, i, j, Integer.MIN_VALUE);
                gMax = Math.max(fromHere, gMax);
            }
        }

        // int max = 0;
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         max = Math.max(max, memo[i][j]);
        //     }
        // }

        return gMax;
    }

    public int dfs(int[][] matrix, int r, int c, int prevValue) {
        boolean inBounds = r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;

        if (!inBounds) return 0;

        if (matrix[r][c] <= prevValue) return 0;

        
        if (memo[r][c] != -1) return memo[r][c];


        int longestAtThisInstance = Integer.MIN_VALUE;
        if (matrix[r][c] > prevValue) {
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                longestAtThisInstance = Math.max(1 + dfs(matrix, nr, nc, matrix[r][c]), longestAtThisInstance);
            }
        }

        memo[r][c] = longestAtThisInstance;
        return longestAtThisInstance;
    }
}

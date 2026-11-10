class Solution {
    int maxRow; 
    int maxCol;
    int[][] dirs = {{1, 0}, {0, 1}};
    int[][] memo;
    public int uniquePaths(int m, int n) {
        // return the count of UNIQUE Paths.
        // no chance of cycling, also dont want a visited set, bcuz we can
        // visit nodes again that another path used and thats fine. 
        // some graph algo:

            // dfs
                // goes as deep as possible 
                    // (so either out of bounds)
                    // or to the goal.
            // bfs

        // can call dfsfrom main function
        // starting from 0, 0 need to count paths to the bottom right.
        // so every time we reach the bottom, we can return 1 and bubble it back up
        // aggregate it in the first call. 
        // if we go out of bounds, we return a 0.
        // return dfs(xyz)
        maxRow = m;
        maxCol = n;
        memo = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0); // returns the unique Paths from 0,0 .
    }

    // optimizations
        // 1) pruning
        // 2) dp? -> so we use a memo to track optimal answers to end
        // memo[r][c] -> uniquePaths to the end.
    
    public int dfs(int r, int c) {
        boolean inBounds = r >= 0 && r < maxRow && c >= 0 && c < maxCol;

        if (!inBounds) return 0;

        if (memo[r][c] != -1) return memo[r][c];

        // no chance of cycling so dont need to mark.
        if (r == maxRow - 1 && c == maxCol - 1) return 1;
        int unique = 0;
        for (int[] dir : dirs) {
            // setup a new row or new col to see
            int nr = r + dir[0]; // 1
            if (nr >= maxRow) continue;
            int nc = c + dir[1]; // 0
            if (nc >= maxCol) continue;
            unique += dfs(nr, nc);
        }
        memo[r][c] = unique;
        return unique;
    }
}

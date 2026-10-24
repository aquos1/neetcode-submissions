class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        // 0 marks cell u cannot visit. 

        // dfs for all paths and jus see accum score atp 
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j)); 
                }
            }
        }
        return max; 
    }

    public int dfs(int[][] grid, int row, int col) {
        boolean inBounds = row >= 0 && row < grid.length && col >= 0 && col < grid[0].length; 
        if (!inBounds || grid[row][col] == 0) return 0;
       
        int curr = grid[row][col];
        grid[row][col] = 0;
        int best = 0;
        for (int[] dir : dirs) best = Math.max(best, dfs(grid, row + dir[0], col + dir[1]));

        grid[row][col] = curr; 
        return best + curr;
    }
}

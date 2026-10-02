class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
    public int orangesRotting(int[][] grid) {
        int fresh = 0; 
        int r = grid.length; 
        int c = grid[0].length; 
        Queue<int[]> q = new LinkedList<>(); 
        boolean[][] vis = new boolean[r][c]; 
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) fresh++; 

                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j}); 
                    vis[i][j] = true; 
                }
            }
        }

        int steps = 0; 
        while (!q.isEmpty() && fresh > 0) {
            //every rotten fruit in there. 
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll(); 
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0]; 
                    int nc = curr[1] + dir[1]; 
                    boolean inBounds = nr >= 0 && nr < r && nc >= 0 && nc < c; 
                    if (!inBounds || grid[nr][nc] != 1) continue; 
                    grid[nr][nc] = 2; 
                    q.offer(new int[] {nr, nc}); 
                    fresh--; 
                }
            }
            steps++; 
        }

        if (fresh != 0) return -1; 

        return steps; 
    }
}

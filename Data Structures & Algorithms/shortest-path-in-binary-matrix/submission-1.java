class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}}; 
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length; 
        int c = grid.length; 

        //return clear path
            //visited cells == 0. 
            //adjacent cells are 8 DIRECTIONALLY CONNECTED. 


        //spt clear path

        Queue<int[]> q = new LinkedList<>(); 
        boolean[][] vis = new boolean[r][c];
        
        if (grid[0][0] == 1 || grid[r- 1][c - 1] == 1) return -1;


        q.offer(new int[] {0, 0, 1});
        vis[0][0] = true; 
        while (!q.isEmpty()) {
                int[] curr = q.poll(); 
                if (curr[0] == r - 1 && curr[1] == r - 1) return curr[2]; 
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0], nc = curr[1] + dir[1], length = curr[2]; 
                    boolean inBounds = nr >= 0 && nr < r && nc >= 0 && nc < c;
                    if (!inBounds || vis[nr][nc] == true || grid[nr][nc] == 1) continue; 
                    q.offer(new int[] {nr, nc, length + 1}); 
                    vis[nr][nc] = true; 
                }
        }
        return -1; 
    }
}
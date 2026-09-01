class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int [] {sr, sc}); 
        boolean[][] vis = new boolean[image.length][image[0].length]; 
        vis[sr][sc] = true; 
        int prev = image[sr][sc]; //1
        image[sr][sc] = color; //2
        while (!q.isEmpty()) {
            int size = 0;
            
                int[] curr = q.poll(); 
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0]; 
                    int nc = dir[1] + curr[1]; 
                    boolean inBounds = nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length; 
                    if (!inBounds) continue; 
                    if (vis[nr][nc]) continue;
                    if (image[nr][nc] != prev) continue;

                    image[nr][nc] = color; 
                    q.offer(new int [] {nr, nc}); 
                    vis[nr][nc] = true; 
                }
        }

        return image; 
     }
}
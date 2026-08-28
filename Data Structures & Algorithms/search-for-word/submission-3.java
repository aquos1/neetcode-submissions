class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
    boolean w = false; 
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    StringBuilder subAnswer = new StringBuilder(); 
                    boolean[][] vis = new boolean[board.length][board[0].length]; 
                    vis[i][j] = true; 
                    subAnswer.append(word.charAt(0)); 
                    traverse(board, vis, i, j, word, subAnswer); 
                    vis[i][j] = false; 
                }
            }
        }
        
        return w; 
    }

    public void traverse(char[][] board, boolean[][] vis, int r, int c, String word, StringBuilder subAnswer) {
        if (subAnswer.length() == word.length() && word.equals(subAnswer.toString())) {
            w = true; 
            return; 
        }

        if (subAnswer.length() > word.length()) return; //come back here

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1]; 
            boolean inBounds = nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length; 
            if (!inBounds) continue; 

            if (vis[nr][nc]) continue; 

            //append that shit.
            vis[nr][nc] = true; 
            subAnswer.append(board[nr][nc]); //ca
            traverse(board, vis, nr, nc, word, subAnswer); 
            vis[nr][nc] = false; 
            subAnswer.deleteCharAt(subAnswer.length() - 1); 
            
        }
    }
}

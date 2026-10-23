class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {

         memo = new int[triangle.size()][];
        // move to index i or i + 1 on the row below

        // so if i have rows and columns, i need to move down via row (always r + 1).
        // but columns can be c or c + 1.

        for (int r = 0; r < triangle.size(); r++) {
            memo[r] = new int[triangle.get(r).size()];
            Arrays.fill(memo[r], Integer.MAX_VALUE);
        }
        return dfs(0, 0, triangle);
    }

    public int dfs(int row, int col, List<List<Integer>> triangle) {
        if (row >= triangle.size()) return 0;

        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        int stay = triangle.get(row).get(col) + Math.min(dfs(row+1, col, triangle), dfs(row+1, col + 1, triangle));

        memo[row][col] = stay;
        return stay; 
    }
}
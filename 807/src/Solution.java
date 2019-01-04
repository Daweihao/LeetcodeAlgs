class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowMax = new int[rows];
        int[] colMax = new int[cols];
        // skyline initialization
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowMax[i] = Math.max(grid[i][j],rowMax[i]);
                colMax[j] = Math.max(grid[i][j],colMax[j]);
            }
        }
        // Max increase for each grid
        int ans = 0;
        for (int i = 0; i < rowMax.length; i++) {
            for (int j = 0; j < colMax.length; j++) {
                ans += (Math.min(rowMax[i],colMax[j]) - grid[i][j]);
            }
        }
        return ans;

    }
}
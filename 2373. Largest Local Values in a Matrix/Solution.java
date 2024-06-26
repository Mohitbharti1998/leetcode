class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = maxLocal(i, j, grid);
            }
        }

        return maxLocal;
    }

    public int maxLocal(int row, int col, int[][] grid) {
        int maxValue = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                maxValue = Math.max(maxValue, grid[i][j]);
            }
        }

        return maxValue;
    }

}

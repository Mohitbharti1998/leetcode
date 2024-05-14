class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int maxGold = 0;

        int totalGold = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                totalGold += grid[i][j];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0){
                    maxGold = Math.max(maxGold, dfs(i, j, grid, visited));
                    if(totalGold == maxGold)
                        return totalGold;
                }
            }
        }

        return maxGold;
    }

    public int dfs(int row, int col, int[][] grid, boolean[][] visited){

        int m = grid.length;
        int n = grid[0].length;

        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == 0 || visited[row][col])
            return 0;

        int maxGold = Integer.MIN_VALUE;
        visited[row][col] = true;
        //up 
        maxGold = Math.max(maxGold, dfs(row-1, col, grid, visited));
        //down
        maxGold = Math.max(maxGold, dfs(row+1, col, grid, visited));
        //left
        maxGold = Math.max(maxGold, dfs(row, col-1, grid, visited));
        //right
        maxGold = Math.max(maxGold, dfs(row, col+1, grid, visited));

        visited[row][col] = false;

        return grid[row][col] + maxGold;
    }
}

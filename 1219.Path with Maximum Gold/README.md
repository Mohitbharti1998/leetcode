# [1219. Path with Maximum Gold](https://leetcode.com/problems/path-with-maximum-gold)

<!-- tags:Array,Backtracking,Matrix -->

## Description

<p>In a gold mine <code>grid</code> of size <code>m x n</code>, each cell in this mine has an integer representing the amount of gold in that cell, <code>0</code> if it is empty.</p>

<p>Return the maximum amount of gold you can collect under the conditions:</p>

<ul>
	<li>Every time you are located in a cell you will collect all the gold in that cell.</li>
	<li>From your position, you can walk one step to the left, right, up, or down.</li>
	<li>You can&#39;t visit the same cell more than once.</li>
	<li>Never visit a cell with <code>0</code> gold.</li>
	<li>You can start and stop collecting gold from <strong>any </strong>position in the grid that has some gold.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[0,6,0],[5,8,7],[0,9,0]]
<strong>Output:</strong> 24
<strong>Explanation:</strong>
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -&gt; 8 -&gt; 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
<strong>Output:</strong> 28
<strong>Explanation:</strong>
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6 -&gt; 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 15</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
	<li>There are at most <strong>25 </strong>cells containing gold.</li>
</ul>

## Solutions

### Solution 1: DFS

We can enumerate each cell as the starting point, and then start a depth-first search from the starting point. During the search process, whenever we encounter a non-zero cell, we turn it into zero and continue the search. When we can no longer continue the search, we calculate the total amount of gold in the current path, then turn the current cell back into a non-zero cell, thus performing backtracking.

The time complexity is $O(m \times n \times 3^k)$, where $k$ is the maximum length of each path. Since each cell can only be visited once at most, the time complexity will not exceed $O(m \times n \times 3^k)$. The space complexity is $O(m \times n)$.

<!-- tabs:start -->

```java
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
```

```go
func getMaximumGold(grid [][]int) (ans int) {
	m, n := len(grid), len(grid[0])
	var dfs func(i, j int) int
	dfs = func(i, j int) int {
		if i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 {
			return 0
		}
		v := grid[i][j]
		grid[i][j] = 0
		ans := 0
		dirs := []int{-1, 0, 1, 0, -1}
		for k := 0; k < 4; k++ {
			ans = max(ans, v+dfs(i+dirs[k], j+dirs[k+1]))
		}
		grid[i][j] = v
		return ans
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			ans = max(ans, dfs(i, j))
		}
	}
	return
}
```

<!-- tabs:end -->

<!-- end -->

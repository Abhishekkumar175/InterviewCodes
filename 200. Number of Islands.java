class Solution {
    int rows;
    int cols;
    public void dfs(int row, int col, char[][] grid, boolean visited[][]){
        //out of bound
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0' || visited[row][col]){
            return;
        }
        visited[row][col]=true;
        int adjList[][] = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[] : adjList){
            dfs(neighbour[0], neighbour[1], grid, visited);
        }
    }
    public int numIslands(char[][] grid) {
       rows=grid.length;
       cols=grid[0].length;
       int islands = 0;
       boolean visited[][] = new boolean[rows][cols];
       for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             if(grid[i][j] == '1' && !visited[i][j]){
                 dfs(i,j,grid,visited);
                 islands++;
               }
            }
        } 

        return islands;
    }
}




/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

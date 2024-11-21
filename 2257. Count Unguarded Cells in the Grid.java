class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        for(int[] guard : guards){
            grid[guard[0]] [guard[1]] = GUARD;
        }

        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = WALL;
        }

        //Mark cell as guarded by traversing from each guard
        for(int[] guard : guards){
            recurse(guard[0]-1,guard[1],grid,'U'); //up
            recurse(guard[0]+1,guard[1],grid,'D'); //down
            recurse(guard[0],guard[1]-1,grid,'L'); //left
            recurse(guard[0],guard[1]+1,grid,'R'); //right
        }

        //count unguarded cells
        int count=0;
        for(int[] row : grid){
            for(int cell : row){
                if(cell == UNGUARDED) {
                    count++;
                }
            }
        }

        return count;
    }

    int UNGUARDED=0, GUARDED=1, GUARD=2, WALL=3;

    //DFS to mark guarded cells
    private void recurse(int row, int col, int[][] grid, char direction){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || 
        grid[row][col]==GUARD || grid[row][col]==WALL){
            return;
        }

        grid[row][col]=GUARDED; //mark cell as guarded
        if(direction == 'U') recurse(row-1, col, grid, 'U');
        if(direction =='D') recurse(row+1, col, grid, 'D');
        if(direction =='L') recurse(row, col-1, grid, 'L');
        if(direction =='R') recurse(row, col+1, grid, 'R');

    }
}





/*
You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.

 

Example 1:


Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
Output: 7
Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.
Example 2:


Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
Output: 4
Explanation: The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.
 

Constraints:

1 <= m, n <= 105
2 <= m * n <= 105
1 <= guards.length, walls.length <= 5 * 104
2 <= guards.length + walls.length <= m * n
guards[i].length == walls[j].length == 2
0 <= rowi, rowj < m
0 <= coli, colj < n
All the positions in guards and walls are unique.
*/ 

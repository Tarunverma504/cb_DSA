package DP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
Accepted
448,531
Submissions
1,220,442
*/
import java.util.*;
public class Unique_Paths_II__LC__63 {
    
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/unique-paths-ii/
        */
    }
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int cache[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
            for(int row[]: cache)
                Arrays.fill(row,-1);
            return getPath(obstacleGrid, obstacleGrid.length-1,obstacleGrid[0].length-1,cache);
        }

        public static int getPath(int[][] grid,int m,int n,int[][] cache){
             if(m<0 || n<0 || grid[m][n]==1)
                return 0;
            if(m==0 && n==0)
                return 1;

            if(cache[m][n]!=-1)
                return cache[m][n];
            int c1 = getPath(grid, m-1, n, cache);
            int c2 = getPath(grid, m, n-1, cache);
            cache[m][n]= c1+c2;
            return cache[m][n];
        }
    }
}

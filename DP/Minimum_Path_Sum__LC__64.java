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
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
*/
import java.util.*;
public class Minimum_Path_Sum__LC__64 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-path-sum/
        */
    }
    static class Solution {
        public int minPathSum(int[][] grid) {

            int cache[][] = new int[grid.length][grid[0].length];
            for(int[] row:cache){
                Arrays.fill(row,-1);
            }
            return getSum(grid, 0, 0, grid.length-1, grid[0].length-1, cache);
        }

        public int getSum(int[][] grid, int cr,int cc,int er,int ec, int[][] cache){

            if(cr>er || cc> ec)
                    return Integer.MAX_VALUE;
            if(cr==er && cc==ec)
                return grid[er][ec];
            if(cache[cr][cc]!=-1)
                return cache[cr][cc];

            int c1 = getSum(grid, cr, cc+1, er, ec,cache);
            int c2 = getSum(grid, cr+1, cc, er,ec,cache);
            cache[cr][cc]= Math.min(c1,c2)+grid[cr][cc];
            return cache[cr][cc];
        }
    }
}

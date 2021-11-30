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
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

 

Example 1:


Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99
*/
import java.util.*;
public class Minimum_Falling_Path_Sum_II__LC__1289 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-falling-path-sum-ii/
        */
    }
    
    static class Solution {
        public int minFallingPathSum(int[][] grid) {

            int min = Integer.MAX_VALUE;
            int cache[][] = new int[grid.length+1][grid[0].length+1];
            for(int[] row: cache)
                Arrays.fill(row,-1);
            for(int i=0;i<grid[0].length;i++){
               min = Math.min(min, getResult(grid,0,i,grid.length,grid[0].length,cache));
            }
            return min;
        }

        public static int getResult(int[][] grid, int cr,int cc, int er, int ec,int[][] cache){

             if(cr==er)
                return 0;
            if(cr == grid.length-1)
                return grid[cr][cc];
            if(cache[cr][cc]!=-1)
                return cache[cr][cc];
            int c1=Integer.MAX_VALUE;
            for(int j=0;j<ec;j++){
                if(j!=cc){
                   c1 = Math.min(c1, getResult(grid, cr+1,j,er,ec,cache));
                }

            }
            cache[cr][cc] = c1+grid[cr][cc];
            return cache[cr][cc];

        }

    }
}

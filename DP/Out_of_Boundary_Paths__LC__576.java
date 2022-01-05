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
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
*/
import java.util.*;
public class Out_of_Boundary_Paths__LC__576 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/out-of-boundary-paths/
        */
    }
    static class Solution { 
        static int mod = 1000000000 + 7;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int dp[][][] =  new int[m+1][n+1][maxMove+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    for(int k=0;k<dp[0][0].length;k++){
                        dp[i][j][k]=-1;
                    }
                }
            }
            return sol(m, n, maxMove, startRow, startColumn, dp);
        }

        public static int sol(int m,int n,int moves, int i, int j,int[][][] dp){
            if(i<0 || j<0 || i>=m || j>=n)
                return 1;
            if(moves==0)
                return 0;
            if(dp[i][j][moves]!=-1)
                return dp[i][j][moves];
            int c1 = sol(m, n, moves-1, i-1, j, dp);
            int c2 = sol(m, n, moves-1, i+1, j, dp);
            int c3 = sol(m, n, moves-1, i, j-1, dp);
            int c4 = sol(m, n, moves-1, i, j+1, dp);
            dp[i][j][moves] = (c1+(c2+(c3+c4)%mod)%mod)%mod;
            return dp[i][j][moves];
        }
    }
}

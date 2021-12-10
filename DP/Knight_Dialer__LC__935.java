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
The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.

 

Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:

Input: n = 3
Output: 46
Example 4:

Input: n = 4
Output: 104
Example 5:

Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.
 

Constraints:

1 <= n <= 5000
Accepted
66.9K
Submissions
138.3K
*/
public class Knight_Dialer__LC__935 {
    
    public static void main(String arg[]){
           /*
            https://leetcode.com/problems/knight-dialer/
        */
    }
    static class Solution {
        static int mod = 1000000007;
        static int r[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        static int c[] = {-2, -1, 1, 2, -2, -1, 1, 2};

        public int knightDialer(int n) {

            int dp[][][] = new int[4][3][n+1];
            for(int i=0; i<4; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k<n+1; k++){
                        dp[i][j][k]=-1;
                    }
                }
            }
            int ans=0;
            for(int r=0;r<4;r++){
               for(int c=0;c<3;c++){
                   ans = (ans+ sol(r, c, n-1, dp)) % mod;
               } 
            }
            return ans;

        }

        public static int sol(int row,int col,int n,int[][][] dp){
            if(row<0 || col<0 || row>=4 || col>=3 || (row==3 && col==0) || (row==3 && col==2))
                return 0;
            if(n==0)
                return 1;
            if(dp[row][col][n]!=-1)
                return dp[row][col][n];
            int ct=0;
            for(int i=0; i<8; i++){
                ct = (ct + sol(row+r[i], col+c[i], n-1, dp))%mod;
            }
            dp[row][col][n] = (ct % mod);
            return dp[row][col][n];


        }
    }
}

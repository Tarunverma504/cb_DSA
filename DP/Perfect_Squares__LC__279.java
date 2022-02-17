/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Mind_Coder
 */
/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
Accepted
499.5K
Submissions
969.1K
Seen this question in a real interview before?
*/
import java.util.*;
public class Perfect_Squares__LC__279 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/perfect-squares/
        */
    }
    static class Solution {
        public int numSquares(int n) {
            if(n<4)
                return n;
            ArrayList<Integer> sq = new ArrayList<Integer>();

            sq.add(1);
            for(int i=2;i*i<=n;i++){
                if(i*i==n)
                    return 1;
                sq.add(i*i);
            }
            int dp[][] = new int[n+1][sq.size()+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            }
            return sol(n, sq, 0, 0, dp);

        }

        public static int sol(int n,ArrayList<Integer> sq, int curr, int currSum,int[][] dp){
            if(curr==sq.size()){
                return Integer.MAX_VALUE-1;
            }
            if(currSum==n)
                return 0;
            if(dp[currSum][curr]!=-1)
                return dp[currSum][curr];
            int c1=Integer.MAX_VALUE;
            if(currSum+sq.get(curr)<=n){
                c1=sol(n, sq, curr, currSum+sq.get(curr), dp)+1;
            }
            int c2 = sol(n, sq, curr+1, currSum, dp);
            dp[currSum][curr]=Math.min(c1, c2);
            return dp[currSum][curr];
        }
    }
}

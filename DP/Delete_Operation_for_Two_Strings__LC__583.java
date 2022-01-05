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
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
*/
import java.util.*;
public class Delete_Operation_for_Two_Strings__LC__583 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/delete-operation-for-two-strings/
        */
    }
    static class Solution {
        public int minDistance(String s1, String s2) {
            int dp[][] = new int[s1.length()+1][s2.length()+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                       dp[i][j]=-1;
                }
            }
            return sol(s1,s2, s1.length(), s2.length(), dp);
        }

        public static int sol(String s, String p,int n,int m,int[][] dp){


            if(n==0 && m==0)
                return 0;
            if(n==0)
                return sol(s, p, n, m-1, dp)+1;
            if(m==0)
                return sol(s, p, n-1, m, dp)+1;
            if(dp[n-1][m-1]!=-1)                
                return dp[n-1][m-1];

            if(s.charAt(n-1)==p.charAt(m-1)){
                dp[n-1][m-1]=sol(s, p, n-1, m-1, dp);
                return dp[n-1][m-1];
            }
            else{
                int c1 = sol(s, p, n-1, m, dp);
                int c2 = sol(s, p, n, m-1, dp);
                dp[n-1][m-1]=Math.min(c1, c2)+1;
                return dp[n-1][m-1];
            }


        }
    }
}

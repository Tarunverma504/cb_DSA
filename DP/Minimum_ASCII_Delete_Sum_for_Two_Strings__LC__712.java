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
Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

 

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 

Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters.
*/
import java.util.*;
public class Minimum_ASCII_Delete_Sum_for_Two_Strings__LC__712 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
        */
    }
    static class Solution {
        public int minimumDeleteSum(String s1, String s2) {

            int dp[][] = new int[s1.length()+1][s2.length()+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            }
            return sol(s1,s2, s1.length(), s2.length(), dp);
        }

        public static int sol(String s, String p, int n, int m, int[][] dp){

            if(n==0 && m==0){
                return 0;
            }
            if(n==0){
                return sol(s, p, n, m-1, dp)+(int)p.charAt(m-1);

            }
            if(m==0){
                return sol(s, p, n-1, m, dp)+(int)s.charAt(n-1);
            }
            if(dp[n-1][m-1]!=-1)
                return dp[n-1][m-1];

            if(s.charAt(n-1)==p.charAt(m-1)){
                dp[n-1][m-1]=sol(s, p, n-1, m-1, dp);
                return dp[n-1][m-1];
            }
            else{
                int c1 = sol(s, p, n-1, m, dp)+(int)s.charAt(n-1);
                int c2 = sol(s, p, n, m-1, dp)+(int)p.charAt(m-1);
                dp[n-1][m-1] = Math.min(c1, c2);
                return dp[n-1][m-1];
            }
        }
    }
}

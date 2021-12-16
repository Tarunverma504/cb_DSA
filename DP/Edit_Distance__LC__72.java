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
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
*/
import java.util.*;
public class Edit_Distance__LC__72 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/edit-distance/
        */
    }
    static class Solution {
        public int minDistance(String word1, String word2) {

            int dp[][] = new int[word1.length()+1][word2.length()+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            }
            return sol(word1, word2, word1.length(), word2.length(), dp);
        }
          //case 1 insertion => n, m-1
    //case 2 deletion => n-1, m
    //case 3 replace => n-1, m-1

        public static int sol(String s1, String s2, int n, int m, int[][] dp){

            if(n==0 && m==0)
                return 0;

            if(n==0)
                return m;
            if(m==0)
                return n;
            if(dp[n][m]!=-1)
                return dp[n][m];
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                dp[n][m] = sol(s1, s2, n-1, m-1, dp);
                return dp[n][m];
            }

            else{
                int in = sol(s1, s2, n, m-1, dp);
                int del = sol(s1, s2, n-1, m, dp);
                int rep = sol(s1, s1, n-1, m-1, dp);
                dp[n][m] = Math.min(in,Math.min(del, rep)) + 1;
                return dp[n][m];
            }
        }

    }
}

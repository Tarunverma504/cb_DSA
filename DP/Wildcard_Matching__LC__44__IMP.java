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
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input: s = "acdcb", p = "a*c?b"
Output: false
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'
*/
import java.util.*;
public class Wildcard_Matching__LC__44__IMP {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/wildcard-matching/
        */
    }
    static class Solution {
        public boolean isMatch(String s, String p) {

            int dp[][] = new int[s.length()+1][p.length()+1];
            for(int row[] : dp){
                Arrays.fill(row,-1);
            }
             int ans =sol(s, p, s.length(), p.length(), dp);
            if(ans ==1)
                return true;
            return false;
        }

        public static int  sol(String s, String p, int n, int m, int[][] dp){

            if(dp[n][m]!=-1)
                return dp[n][m];
            if(n==0){
                if(m==0){
                    // return true; // if both strings get empty
                    return 1;
                }

                // if n==0 but m!=0 means s is empty but p is not empty
                if(p.charAt(m-1)!='*'){
                    // return false;
                    return 0;
                }
                else{
                    dp[n][m] = sol(s, p, n, m-1, dp);
                    return dp[n][m];
                }
            }

            if(m==0){ // s is not empty but p is empty
                // return false;
                return 0;
            }


            if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1)=='?'){
                dp[n][m] = sol(s, p, n-1, m-1, dp);
                return dp[n][m];
            }
            else if(p.charAt(m-1)=='*'){
                int  c1 = sol(s, p, n-1 , m, dp); // if * matched with char (abce , *a*) => (ab, *a*)
                int c2 = sol(s, p, n, m-1, dp); // if we doesn't match * with char (abce, *a*) => (abce, *a)
                dp[n][m] = Math.max(c1,c2);
                return dp[n][m];
            }
            else
                // return false;
                return 0;
        }

    }
}

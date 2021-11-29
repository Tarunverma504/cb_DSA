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
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.
*/
import java.util.*;
public class Distinct_Subsequences__LC__115 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/distinct-subsequences/
        */
    }
    
    static class Solution {
        public int numDistinct(String s, String t) {

            int[][] cache = new int[s.length()+1][t.length()+1];
            for(int[] row:cache)
                Arrays.fill(row,-1);
            return sol(s,t,0,0,cache);
        }

        public static int sol(String s, String t, int currS, int currT,int[][] cache){

            if(currT == t.length())
                return 1;
            if(cache[currS][currT]!= -1)
                return cache[currS][currT];
            if(currS == s.length())
                return 0;
            int incl=0;
            if(s.charAt(currS) == t.charAt(currT)){
                incl = sol(s, t, currS+1, currT+1,cache);
            }

            int excl =0;
            excl = sol(s,t,currS+1,currT,cache);
            cache[currS][currT] = incl + excl;
            return cache[currS][currT];
        }
    }
}

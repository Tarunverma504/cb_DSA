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
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
*/
import java.util.*;
public class Longest_Common_Subsequence__LC__1143 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-common-subsequence/
        */
    }
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            int cache[][] = new int[text1.length()][text2.length()];
            for(int row[] :cache)
                Arrays.fill(row,-1);
            return getResult(text1, 0, text2, 0, cache);
        }

        public static int getResult(String s, int cs, String t, int ct, int[][] cache){

            if(cs == s.length() || ct==t.length())
                return 0;
            if(cache[cs][ct]!=-1)
                return cache[cs][ct];
            if(s.charAt(cs)==t.charAt(ct)){
                return getResult(s, cs+1, t, ct+1, cache)+1;
            }
            else{
                int c1 = getResult(s,cs+1,t,ct,cache);
                int c2 = getResult(s,cs,t,ct+1,cache);
                cache[cs][ct] = Math.max(c1,c2);
                return cache[cs][ct];
            }
        }

    }
}

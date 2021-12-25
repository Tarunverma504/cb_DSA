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
public class Longest_Common_Subsequence__LC__1143__ITERATIVE {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-common-subsequence/
        */
    }
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            int tab[][] = new int[text1.length()+1][text2.length()+1];
            for(int i=0;i<tab.length;i++){
                for(int j=0;j<tab[0].length;j++){
                    if(i==0 ||j==0){
                        tab[i][j]=0;
                    }
                }
            }

            for(int i=1;i<tab.length;i++){
                for(int j=1;j<tab[0].length;j++){

                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        tab[i][j]=1+tab[i-1][j-1];
                    }
                    else{
                        tab[i][j]=Math.max(tab[i-1][j],tab[i][j-1]);
                    }
                }
            }
            return tab[text1.length()][text2.length()];
        }
    }
}

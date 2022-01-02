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
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
*/
public class Longest_Palindromic_Subsequence__LC__516 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-palindromic-subsequence/
        */
    }
    
    static class Solution {
        public int longestPalindromeSubseq(String s) {
            String t="";
            for(int i=s.length()-1; i>=0;i--){
                t+=s.charAt(i);
            }

            return lcs(s,t);
        }

        public static int lcs(String s, String t){
            int tab[][] = new int[s.length()+1][t.length()+1];
            for(int i=0; i<tab.length; i++){
                for(int j=0;j<tab[0].length; j++){
                    if(i==0 || j==0)
                        tab[i][j]=0;
                }
            }

            for(int i=1;i<tab.length; i++){
                for(int j=1;j<tab[0].length;j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        tab[i][j]=tab[i-1][j-1]+1;
                    }
                    else{
                        tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                    }

                }
            }
            return tab[s.length()][t.length()];
        }
    }
    
}

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
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/
public class Longest_Palindromic_Substring__LC__5 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-palindromic-substring/
        */
    }
    static class Solution {
        public String longestPalindrome(String s) {
            boolean dp[][] = new boolean[s.length()][s.length()];
            int start=0,end=0,len=0;
            for(int g=0;g<s.length();g++){
                for(int i=0, j=g;i<s.length() && j<s.length();i++,j++){
                    if(g==0)
                        dp[i][j]=true;
                    else if(g==1){
                        if(s.charAt(i)==s.charAt(j))
                            dp[i][j] = true;
                        else
                            dp[i][j]=false;
                    }
                    else{
                        if(s.charAt(i)==s.charAt(j)){
                            if(dp[i+1][j-1]==true)
                                dp[i][j]=true;
                            else
                                dp[i][j]=false;
                        }
                        else
                            dp[i][j]=false;
                    }
                    if(dp[i][j]==true && len<g+1 ){
                        len=g+1;
                        start=i;
                        end=j+1;
                    }
                }
            }
            return s.substring(start,end);
        }
    }
}

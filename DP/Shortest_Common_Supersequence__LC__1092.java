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
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
*/

import java.util.*;
public class Shortest_Common_Supersequence__LC__1092 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/shortest-common-supersequence/
        */
    }
    static class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int tab[][] = lcs(str1, str2);  
            String ans = getAns(tab, str1, str2, tab[tab.length-1][tab[0].length-1]);
            return ans;
        }

        public static String getAns(int[][] tab, String x, String y,int len){
            // char ch[] = new char[len+1];
            // len--;
            String ch="";
            int i=x.length();
            int j=y.length();
            while(i>0 && j>0){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    ch+=(x.charAt(i-1));
                    i--;
                    j--;
                }
                else{

                    if(tab[i-1][j] > tab[i][j-1]){
                        ch+= (x.charAt(i-1));
                        i--;
                        // len--;
                    }
                    else{
                        ch+= (y.charAt(j-1));
                        j--;
                        // len--;
                    }

                }
            }
            while(i>0){
                ch+= (x.charAt(i-1));
                        i--;
            }
            while(j>0){
                ch+= (y.charAt(j-1));
                        j--;
            }
            StringBuilder ans = new StringBuilder();
            for(i=ch.length()-1; i>=0;i--){
                ans.append(ch.charAt(i));
            }
            return ans.toString();
        }

        public static int[][] lcs(String s1, String s2){
            int tab[][] = new int[s1.length()+1][s2.length()+1];
            for(int i=0;i<tab.length;i++){
                tab[i][0]=0;
            }
            for(int j=0;j<tab[0].length;j++){
                        tab[0][j]=0;
                }

            for(int i=1;i<s1.length()+1;i++){
                for(int j=1;j<s2.length()+1;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        tab[i][j]=tab[i-1][j-1]+1;
                    }
                    else{
                        tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                    }
                }
            }

            return tab;



        }
    }
}

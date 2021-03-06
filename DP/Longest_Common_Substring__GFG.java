/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Mind_Coder
 */
/*
Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() which takes the string S1, string S2 and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).


Constraints:
1<=n, m<=1000

View Bookmarked Problems
Company Tags
Topic Tags
Related Courses
We are replacing the old Disqus forum with the new Discussions section given below.
Click here to view old Disqus comments.
*/
import java.util.*;
public class Longest_Common_Substring__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#
        */
    }
    static class Solution{
        int longestCommonSubstr(String S1, String S2, int n, int m){
            // code here
            int tab[][] = new int[n+1][m+1];
            int res=0;
            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0)
                        tab[i][j]=0;
                    else if(S1.charAt(i-1)==S2.charAt(j-1)){
                        tab[i][j]=tab[i-1][j-1]+1;
                        res=Math.max(res, tab[i][j]);
                    }
                    else{
                        tab[i][j]=0;
                    }
                }
            }
            return res;
        }
    }
}

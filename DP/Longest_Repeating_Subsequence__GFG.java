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
Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.

Example 1:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.
Example 2:

Input:
str = "aab"
Output: 1
Explanation: 
The longest reapting subsequenece is "a".

Your Task:
You don't need to read or print anything. Your task is to complete the LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)


Constraints:
*/
import java.util.*;
public class Longest_Repeating_Subsequence__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#
        */
    }
    static class Solution
    {
        public int LongestRepeatingSubsequence(String str)
        {
            // code here

            return custom_lcs(str, str);
        }
        public static int custom_lcs(String s, String t){
            int tab[][] = new int[s.length()+1][t.length()+1];
            for(int i=0;i<tab.length;i++){
                tab[i][0]=0;
            }
            for(int i=0;i<tab[0].length;i++){
                tab[0][i]=0;
            }

            for(int i=1;i<tab.length;i++){
                for(int j=1;j<tab[0].length;j++){
                    if(s.charAt(i-1) == t.charAt(j-1) && i!=j){
                        tab[i][j] = tab[i-1][j-1]+1;
                    }
                    else{
                        tab[i][j]=Math.max(tab[i][j-1], tab[i-1][j]);
                    }
                }
            }
            return tab[s.length()][t.length()];

        }
    }
}

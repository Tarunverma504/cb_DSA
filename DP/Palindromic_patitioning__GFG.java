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
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ length of str ≤ 5001 ≤ length of str ≤ 500

*/
import java.util.*;
public class Palindromic_patitioning__GFG {
    public static void main (String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#
        */
    }
    static class Solution{
        static int palindromicPartition(String str)
        {
            // code here
            int cache[][] = new int[str.length()+1][str.length()+1];
            for(int i=0;i<cache.length;i++){
                for(int j=0;j<cache[0].length;j++){
                    cache[i][j]=-1;
                }
            }
            return sol(str, 0, str.length()-1, cache);
        }

        public static int sol(String s, int i, int j,int[][] dp){
            if(i>=j)
                return 0;
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            if(isPalidrome(s, i, j)==true)
                return 0;
                int min = Integer.MAX_VALUE;
            for(int k=i; k<j;k++){
                int tempAns = sol(s, i, k, dp) + sol(s, k+1, j, dp)+1;
                min = Math.min(min, tempAns);
            }
            dp[i][j] = min;
            return min;
        }

        public static boolean isPalidrome(String s, int i, int j){
            while(i<j){
                if(s.charAt(i)!=s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }

}

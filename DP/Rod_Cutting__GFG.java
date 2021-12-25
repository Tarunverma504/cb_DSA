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
Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

 

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
*/
import java.util.*;
public class Rod_Cutting__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/rod-cutting0840/1#
        */
    }
    static class Solution{
        public int cutRod(int price[], int n) {
            //code here
            int len[]  = new int[n];
            for(int i=0;i<n;i++){
                len[i]=i+1;
            }
            int dp[][] = new int[n+1][n+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    dp[i][j]=-1;
                }
            }
            return sol(price,len, n, len.length, dp);
        }

        public static int sol(int price[], int len[], int n, int currlen,int dp[][]){

            if(n==0 || currlen==0){
                return 0;
            }
            if(dp[n][currlen]!=-1){
                return dp[n][currlen];
            }
            int cut=0;
            if(len[n-1]<=currlen){
                cut = sol(price, len, n, currlen-len[n-1], dp)+price[n-1];
            }
            int dontcut = sol(price, len, n-1, currlen, dp);
            dp[n][currlen] = Math.max(cut, dontcut);
            return dp[n][currlen];
        }
    }
}

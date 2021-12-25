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
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct
View Bookmarked Problems
Company Tags
Topic Tags
Related Courses
Related Interview Experiences
We are replacing the old Disqus forum with the new Discussions section given below.
Click here to view old Disqus comments.
*/
import java.util.*;
public class Number_of_Coins__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/number-of-coins1824/1#
        */
    }
    static class Solution{

	public int minCoins(int coins[], int m, int v) 
	{ 
	    // Your code goes here
	    flag=false;
	    int dp[][] = new int[m+1][v+1];
	    for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[0].length;j++){
	            dp[i][j]=-1;
	        }
	    }
	    int res=sol(coins, m, v, dp);
	   // System.out.println(Integer.MAX_VALUE);
	     return flag==false? -1:res;
	} 
	static boolean flag;
	public static int sol(int coins[], int m, int v, int[][] dp){
	    
	    
	    if(m==0)
	        return Integer.MAX_VALUE-1;
	   if(v==0){
	       flag=true;
	       return 0;
	   }
	        
	    if(dp[m][v]!=-1)
	        return dp[m][v];
	    
	    if(coins[m-1]>v){
	        dp[m][v]  = sol(coins, m-1, v, dp);
	        return dp[m][v];
	        
	    }
	    int pick= 1 + sol(coins, m, v-coins[m-1], dp);
	    int dontpick = sol(coins, m-1, v, dp);
	        dp[m][v] = Math.min(pick,dontpick);
	        return dp[m][v];
	}
    }
}

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
Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1 
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
Example 2:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 30
Output: 0 
Explanation: There is no subset with sum 30.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.
 

Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum*N)
 

Constraints:
1 <= N <= 100
1<= arr[i] <= 100
1<= sum <= 105

View Bookmarked Problems
Company Tags
Topic Tags
*/
import java.util.*;
public class Subset_Sum_Problem__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&page=4&query=category[]Dynamic%20Programmingpage4category[]Dynamic%20Programming#
        */
    }
    static class Solution{
        static Boolean isSubsetSum(int n, int arr[], int sum){
            // code here

            int dp[][] = new int[n+1][sum+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            }
            if(sol(n, arr, sum, dp)==1){
                return true;
            }
            else{
                return false;
            }
        }

        public static int sol(int n, int arr[], int sum, int[][] dp){

            if(sum==0)
                return 1;
            if(n<=0)
                return 0;

            if(dp[n][sum]!=-1){
                return dp[n][sum];
            }

            if(arr[n-1]>sum){
                return dp[n][sum] = sol(n-1, arr, sum, dp);
            }
            else{
                if( sol(n-1, arr, sum, dp)!=0 ||  sol(n-1, arr, sum-arr[n-1], dp)!=0){
                    return dp[n][sum]=1;
                }
                else{
                    return dp[n][sum]=0;
                }
            }
            // return dp[n-1][sum];
        }
    }
}

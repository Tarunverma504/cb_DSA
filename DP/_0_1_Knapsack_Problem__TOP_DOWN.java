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
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000

View Bookmarked Problems
*/
import java.util.*;
public class _0_1_Knapsack_Problem__TOP_DOWN {
    
    public static void main(String arg[]){
        /*
        `https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
        */
    }
    static class Solution 
    { 
        //Function to return max value that can be put in knapsack of capacity W.
        static int knapSack(int w, int wt[], int val[], int n) 
        { 
             // your code here 
             int arr[][] = new int[n+1][w+1];

             for(int i=0;i<=n;i++){
                 for(int j=0;j<=w;j++){
                     if(i==0 || j==0)
                        arr[i][j]=0;
                     else if(wt[i-1]<=j){
                         arr[i][j] = Math.max(val[i-1]+arr[i-1][j-wt[i-1]], arr[i-1][j]);
                     }
                     else{
                         arr[i][j]=arr[i-1][j];
                     }
                 }
             }
             return arr[n][w];
        } 
    }
}
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
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 



Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1 
Output: 4 
*/
import java.util.*;
public class Count_of_subsets_with_sum_equal_to_X_using_Recursion {
    public static int count=0;
    
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5};
        int sum = 7;
        int s = 0; // Initially assigning the sum of subset
                   // to be zero
        int n = arr.length;
 
        System.out.print(subsetSum(arr, n, sum, s));
    }
    
    public static int subsetSum(int[] arr,int n, int sum, int currSum){
        
        if(sum==currSum){
            return 1;
        }
        if(n<=0){
            
            return 0;
        }
        int c1 = subsetSum(arr, n-1, sum, currSum+arr[n-1]);
        int c2 = subsetSum(arr, n-1, sum, currSum);
        return c1+c2;
    }
}

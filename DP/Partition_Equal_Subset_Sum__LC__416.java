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
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
public class Partition_Equal_Subset_Sum__LC__416 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/partition-equal-subset-sum/
        */
    }
    static class Solution {
        public boolean canPartition(int[] nums) {

            int sum=0;

            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }

            if(sum%2!=0)
                return false;
            sum= sum/2;
            int dp[][] = new int[nums.length+1][sum+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            }

            if(sol( nums.length,nums, sum, dp)==1)
                return true;


            return false;
        }

        public static int sol(int n,int[] arr,  int sum, int[][] dp){

            if(sum==0){
                return 1;
            }
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
                    return dp[n][sum]  = 1;
                }
                else{
                    return dp[n][sum]  = 0;
                }
            }
        }
    }
}

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
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/
public class Target_Sum__Lc__494 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/target-sum/
        */
    }
    static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return getResult(nums,0,0,target);
        }

        public static int getResult(int[] arr,int curr,int sum,int target){

            if(curr==arr.length && target==sum)
                return 1;
            if(curr>=arr.length)
                return 0;
            int pos = getResult(arr,curr+1,sum+arr[curr],target);
            int neg = getResult(arr,curr+1,sum-arr[curr],target);
            return pos+neg;
        }
    }
}

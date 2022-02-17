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
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/
import java.util.*;
public class Jump_Game_II__LC__45 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/jump-game-ii/
        */
    }
    static class Solution {
        public int jump(int[] nums) {
            int dp[] = new int[nums.length];
            Arrays.fill(dp, -1);
            return sol(nums,0, dp);
        }

        public static int sol(int[] nums,int curr,int[] dp){
            if(curr>=nums.length-1)
                return 0;
            if(dp[curr]!=-1)
                return dp[curr];
            int jumps=nums[curr];
            int min = Integer.MAX_VALUE/2;
            for(int i=1;i<=jumps;i++){
                min = Math.min(min, sol(nums, curr+i, dp)+1);
            }
            dp[curr] = min;
            return dp[curr];
        }
    }
}

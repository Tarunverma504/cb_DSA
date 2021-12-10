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
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/
import java.util.*;
public class House_Robber_II__LC__213 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/house-robber-ii/
        */
    }
    static class Solution {
        public int rob(int[] nums) {
            if(nums.length==1)
                return nums[0];
            int cache[] = new int[nums.length+1];
            Arrays.fill(cache,-1);
            int case1 = getResult(nums,0,nums.length-1,cache);
            Arrays.fill(cache,-1);
            int case2 = getResult(nums,1,nums.length,cache);
            return Math.max(case1,case2);
        }

        public static int getResult(int[] nums,int curr,int end,int[] cache){

            if(curr>=end)
                return 0;
            if(cache[curr]!=-1)
                return cache[curr];
            int rob = getResult(nums,curr+2,end,cache)+nums[curr];
            int dontrob = getResult(nums,curr+1,end,cache);
            cache[curr] = Math.max(rob,dontrob);
            return cache[curr];
        }
    }
}

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
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
Accepted
889,071
Submissions
1,965,868
*/
import java.util.*;
public class House_Robber__LC__198 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/house-robber/
        */
    }
    
    static class Solution {
        public int rob(int[] nums) {
            int cache[] = new int[nums.length+1];
            Arrays.fill(cache, -1);
            return rob(nums, nums.length, cache);
        }

        public static int rob(int[] nums, int n,int cache[]){

            if(n<=0)
                return 0;
            if(cache[n]!=-1)
                return cache[n];
            int rob = rob(nums, n-2, cache)+nums[n-1];
            int dont_rob = rob(nums, n-1, cache);
            cache[n] = Math.max(rob,dont_rob);
            return cache[n];
        }
    }
    
//    static class Solution {
//        public int rob(int[] nums) {
//            int cache[] = new int[nums.length+1];
//            Arrays.fill(cache,-1);
//            return rob(nums,0,nums.length,cache);
//        }
//
//        public static int rob(int[] nums,int curr,int n,int[] cache){
//
//            if(curr>=n)
//                return 0;
//            if(cache[curr]!=-1){
//                return cache[curr];
//            }
//            int rob = rob(nums, curr+2, n,  cache)+nums[curr];
//            int dont_rob = rob(nums, curr+1, n,  cache);
//            cache[curr] = Math.max(rob,dont_rob);
//            return cache[curr];
//
//        }
//    }
}

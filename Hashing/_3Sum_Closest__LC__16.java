package Hashing;

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
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/
import java.util.*;
public class _3Sum_Closest__LC__16 {
 
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/3sum-closest/
        */
    }
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans=nums[0]+nums[1]+nums[2];
            for(int i=0;i<nums.length;i++){
                int l=i+1;
                int r=nums.length-1;
                while(l<r){
                    int currSum = nums[i]+nums[l]+nums[r];
                    if(Math.abs(target-currSum)<Math.abs(target-ans)){
                        ans = currSum;
                    }
                    if(currSum<target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
            return ans;
        }
    }
}

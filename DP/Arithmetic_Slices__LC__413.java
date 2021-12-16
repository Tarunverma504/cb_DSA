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
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
Accepted
161K
Submissions
260.8K
*/
import java.util.*;
public class Arithmetic_Slices__LC__413 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/arithmetic-slices/
        */
    }
    
    static class Solution {
        static int ap ;
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums.length ==0 || nums.length==1)
                return 0;
            ap=0;
            sol(nums, 0);
            return ap;

        }

        // ans = ans + (ans+1);
        // so to store the previous ans we take ap global variable
        // ap = ap +(ans +1);
        public static int sol(int[] arr, int i){

            if(i==arr.length-2)
                return 0;
            int ans =0;
            if(arr[i+2] - arr[i+1] == arr[i+1]-arr[i]){
                ans = sol(arr, i+1)+1; // difference is common
                ap+= ans;
            }
            else{
                sol(arr, i+1); // when difference is not common
            }
            return ans;
        }
    }
}

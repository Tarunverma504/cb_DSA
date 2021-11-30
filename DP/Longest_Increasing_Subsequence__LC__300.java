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
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

Accepted
706.1K
Submissions
1.5M
Seen this question in a real interview before?

Yes

No



/6


*/
import java.util.*;
public class Longest_Increasing_Subsequence__LC__300 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-increasing-subsequence/
        */
    }
    static class Solution {
        public int lengthOfLIS(int[] nums) {

            int[][] cache = new int [nums.length+1][nums.length+1];
            for(int[] row: cache)
                Arrays.fill(row,-1);

            return getResult(nums, -1, 0, nums.length,cache);
        }

        public int getResult(int[] nums,int prev,int curr,int n,int[][] cache){

            if(curr==n)
                return 0;
            if(cache[curr][prev+1]!=-1)
                return cache[curr][prev+1];
            int incl =0;
            if(prev==-1 || nums[prev]<nums[curr])
                incl = getResult(nums, curr, curr+1, n,cache)+1;
            int excl = getResult(nums, prev, curr+1, n,cache);
            cache[curr][prev+1] = Math.max(incl,excl);
            return cache[curr][prev+1];
        }
    }
}

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
You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
Example 2:

Input: nums = [13,10,35,24,76]
Output: 4
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
*/
import java.util.*;
public class Count_Nice_Pairs_in_an_Array__LC__1814 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/count-nice-pairs-in-an-array/
        */
    }
    static class Solution {
    
        static int mod = 1000000007;
        public int countNicePairs(int[] arr) {

            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            int count=0;
            for(int i=0;i<arr.length;i++){
                int curr = arr[i];
                int diff = curr-rev(curr);

                if(hm.containsKey(diff)){
                    count=(count + hm.get(diff))%mod;
                }
                hm.put(diff, hm.getOrDefault(diff,0)+1);
            }
            return count % mod;
        }

        public static int rev(int curr){
            int c=0;
            while(curr>0){
                int r=curr%10;
                c=c*10+r;
                curr=curr/10;
            }
            return c%mod;
        }
    }
}

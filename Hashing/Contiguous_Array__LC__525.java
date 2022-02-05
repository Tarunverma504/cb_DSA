/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author Mind_Coder
 */
/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
Accepted
233.4K
Submissions
512.4K
Seen this question in a real interview before?
*/
import java.util.*;
public class Contiguous_Array__LC__525 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/contiguous-array/
        */
    }
    class Solution {
        public int findMaxLength(int[] nums) {
            //sum, indx
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0, -1);
            int len =0;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    sum+=-1;
                }
                else{
                    sum+=1;
                }
                if(hm.containsKey(sum)){
                    int idx = hm.get(sum);
                    len = Math.max(len, i-idx);
                }
                else{
                    hm.put(sum, i);
                }
            }
            return len;
        }
    }
}

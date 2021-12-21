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
Description
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

There is at least one subarray that it's sum equals to zero.

Example
Example 1:

Input:  [-3, 1, 2, -3, 4]
Output: [0, 2] or [1, 3].
Explanation: return anyone that the sum is 0.
Example 2:

Input:  [-3, 1, -4, 2, -3, 4]
Output: [1,5]	
*/
import java.util.*;
public class Subarray_Sum__LINT__138 {
    
    public static void main(String arg[]){
        /*
            https://www.lintcode.com/problem/138/
        */
    }
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> ans = new ArrayList<Integer>();
        int sum=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l=0,r=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==0){  // sum[0,i]=0 
                l=0;
                r=i;
                break;
            }
            else if(hm.containsKey(sum)){
                l=hm.get(sum)+1;
                r=i;
                break;
            }
            else{
                hm.put(sum, i);
            }
        }
        ans.add(l);
        ans.add(r);
        return ans;
    }
}

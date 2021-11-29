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
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104
Accepted
95,589
Submissions
177,459
*/
import java.util.*;
public class Delete_and_Earn__LC__740 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/delete-and-earn/
        */
    }
    
    static class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                max = Math.max(nums[i],max);
            }

            int arr[] = new int[max+1];
            for(int i=0;i<nums.length;i++){
                arr[nums[i]]+=nums[i];
            }

            int cache[] = new int[arr.length+1];
            Arrays.fill(cache,-1);
            return rob(arr,arr.length,cache);


        }
        // same logic as house robber 

        public static int rob(int[] arr,int n,int[] cache){

            if(n<=0)
                return 0;
            if(cache[n]!=-1)
                return cache[n];
            int rob = rob(arr,n-2,cache)+arr[n-1];
            int dont_rob = rob(arr,n-1,cache);
            cache[n] = Math.max(rob,dont_rob);
            return cache[n];
        }
    }
}

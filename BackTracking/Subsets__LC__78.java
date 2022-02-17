/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

/**
 *
 * @author Mind_Coder
 */
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Accepted
982.4K
Submissions
1.4M
Seen this question in a real interview before?
*/
import java.util.*;
public class Subsets__LC__78 {
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/subsets/
        */
    }
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            solve(nums, 0, ans, temp);
            return ans;
        }

        public static void solve(int[] nums, int i, List<List<Integer>> ans, List<Integer> temp){
            if(i>=nums.length){
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(nums[i]);
            solve(nums, i+1, ans, temp);
            temp.remove(temp.size()-1);
            solve(nums, i+1, ans, temp);
        }
    }
}

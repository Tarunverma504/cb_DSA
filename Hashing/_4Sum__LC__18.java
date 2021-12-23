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
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
import java.util.*;
public class _4Sum__LC__18 {
 
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/4sum/
        */
    }
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res=new ArrayList<>();
            LinkedHashSet<List<Integer>> set=new LinkedHashSet<>();
            int n=nums.length;
            for(int i=0;i<n-3;i++){
                if(i>0 && nums[i]==nums[i-1]) 
                    continue;
                for(int j=i+1;j<n-2;j++){
                    if(j>i+1 && nums[j]==nums[j-1])
                        continue;
                    int left=j+1;
                    int right=n-1;
                    while(left<right){
                        if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[left]);
                            temp.add(nums[right]);
                            set.add(temp);
                            left++;
                        }
                        else if(nums[i]+nums[j]+nums[left]+nums[right]<target)
                            left++;
                        else
                            right--;
                    }
                }
            }

            Iterator<List<Integer>> it = set.iterator();
            while(it.hasNext()){
                res.add(it.next());
            }
            return res;
        }
    }
}

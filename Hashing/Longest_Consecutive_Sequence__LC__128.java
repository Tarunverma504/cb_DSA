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
/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
import java.util.*;
public class Longest_Consecutive_Sequence__LC__128 {
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/longest-consecutive-sequence/
        */
    }
    static class Solution {
        public int longestConsecutive(int[] arr) {
            //return sol1(arr);
            return sol2(arr);

        }

        public static int sol1(int arr[]){
            if(arr.length<1)
                return 0;
            Arrays.sort(arr);
            int ans =0;
            int currlen = 1;
            for(int i=1;i<arr.length;i++){
                if(arr[i]==arr[i-1]){
                    continue;
                }
                else if(arr[i]-arr[i-1]==1){
                    currlen++;
                }
                else{
                    ans = Math.max(ans , currlen);
                    currlen =1;
                }
            }
            return Math.max(ans, currlen);
        }

        public static int sol2(int arr[]){
            if(arr.length<1)
                return 0;
            HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
            for(int e:arr){
                hm.put(e, true);
            }
            int maxL=0;
            for(int i=0;i<arr.length;i++){
                if(hm.containsKey(arr[i] - 1)){
                    hm.put(arr[i], false);
                }
                else{
                    int currL = 1;

                                    while (hm.containsKey(arr[i] + currL)) {
                                            currL++;
                                    }

                                    maxL = Math.max(maxL, currL);
                }
            }
            return maxL;
        }
    }
}

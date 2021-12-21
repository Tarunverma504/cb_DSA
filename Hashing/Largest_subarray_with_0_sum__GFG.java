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
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
*/
import java.util.*;
public class Largest_subarray_with_0_sum__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
        */
    }
    static class GfG
    {
        int maxLen(int arr[], int n)
        {
            // Your code here

            int ans=0;
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum==0){
                    int currLen = i+1;
                    ans = Math.max(ans, currLen);
                }
                else if(hm.containsKey(sum)){
                    int currLen = i-hm.get(sum);
                    ans=Math.max(ans, currLen);
                }
                else{
                    hm.put(sum, i);
                }
            }
            return ans;
        }
    }
}

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
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function smallestSubsegment() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105
*/
import java.util.*;
public class Longest_Sub_Array_with_Sum_K__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
        */
    }
    static class Solution{
        // Function for finding maximum and value pair
        public static int lenOfLongSubarr (int A[], int N, int k) {
            //Complete the function
            HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
            int ans=0;
            int sum=0;
            for(int i=0;i<N;i++){
                sum+=A[i];
                if(sum==k){
                    int currLen = i+1;
                    ans=Math.max(ans, currLen);

                }
                else if(hm.containsKey(sum-k)){
                    int currLen = i- hm.get(sum-k);
                    ans = Math.max(ans, currLen);
                }
                if(!hm.containsKey(sum)){
                    hm.put(sum, i);
                }
            }
            return ans;
        }


    }
}

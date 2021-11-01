/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Mind_Coder
 */
/*
Given an array nums of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
The leftmost element of the subarray is not larger than other elements in the subarray.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 50000
2. 0 <= nums[i] <= 100000
Sample Input
5
1
4
2
5
3
Sample Output
11



*/
import java.util.*;
public class Number_Of_Valid_Subarrays {
    public static void main(String arg[]){
        /*
        https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/number-of-valid-subarrays-official/ojquestion
        */
    }
    public static int validSubarrays(int[] nums) {
      Stack<Integer> st = new Stack<Integer>();
      int arr[]=new int[nums.length];
      arr[arr.length-1]=nums.length;
      st.push(nums.length-1);
      for(int i=nums.length-2;i>=0;i--){
        while(!st.isEmpty() && nums[st.peek()]>=nums[i])
            st.pop();
        if(st.isEmpty())
            arr[i]=arr.length;
        else
            arr[i]=st.peek();
        st.push(i);
      }
      int sum=0;
      for(int i=0;i<arr.length;i++)
        sum+=arr[i]-i;
      return sum;
      
  }
}

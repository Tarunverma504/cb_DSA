package stack;

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
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 
*/

import java.util.*;
public class Daily_Temperatures_LC_739 {
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/daily-temperatures/
        */
    }
    public class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> st = new Stack<Integer>();
            int n=temperatures.length;
            st.push(n-1);
            int arr[] = new int[n];
            arr[n-1]=0;
            for(int i=temperatures.length-2;i>=0;i--){
                while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i])
                    st.pop();
                if(st.isEmpty())
                    arr[i]=0;
                else
                    arr[i]=st.peek()-i;
                st.push(i);
            }
            return arr;
        }
    }
}

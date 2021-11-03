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
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 
*/
import java.util.*;
public class Remove_K_Digits__LC__402 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/remove-k-digits/
        */
    }
    static class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == 0 || num.length() == k) return "0";
            if (k == 0) return num;
            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<num.length();i++){
                char ch = num.charAt(i);
                while(!st.isEmpty() && st.peek()>ch && k>0){
                    st.pop();
                    k--;
                }
                st.push(ch);
            }
            while(k>0){
                st.pop();
                k--;
            }
            char arr[] = new char[st.size()];
            for(int i=arr.length-1;i>=0;i--){
                arr[i]=st.pop();
            }
            int d=0;
            while(d<arr.length && arr[d]=='0')
                d++;
            StringBuilder sb = new StringBuilder();
            while(d<arr.length)
                sb.append(arr[d++]);
            if(sb.length()==0)
                return "0";
            return sb.toString();
        }
    }
}

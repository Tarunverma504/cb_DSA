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
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
*/
import java.util.*;
public class Validate_Stack_Sequences__lc__946 {
    public static void main(String arg[]){
        /*
        `https://leetcode.com/problems/validate-stack-sequences/
        */
    }
 
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            Stack<Integer> st = new Stack<Integer>();
            int j=0;
            for(int i=0;i<pushed.length;i++){
                st.push(pushed[i]);
                while(!st.isEmpty() && st.peek()==popped[j]){
                    st.pop();
                    j++;
                }

            }
            return j==popped.length;

        }
    }
}

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
Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
Example 4:

Input: s = "(()(()))"
Output: 6
*/

import java.util.*;
public class Score_of_Parentheses__LC__856 {
    static class Solution {
        public int scoreOfParentheses(String S) {
            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<S.length();i++){
               char ch=S.charAt(i);
                if(ch=='(')
                 st.push(ch);
                else{
                    if(st.peek()=='('){
                        st.pop();
                        st.push('1');
                    }
                    else{
                        int num=0;
                        while(st.peek()!='('){
                            num=num+(st.pop()-'0');
                        }
                        num=2*num;
                        st.pop();
                        char c=(char)(num+'0');
                        st.push(c);
                    }
                }

            }
            int ans=0;
            while(!st.isEmpty()){
                ans+=(st.pop()-'0');
            }
            return ans;
        }
    }
}

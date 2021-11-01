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
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 
*/
import java.util.*;
public class Remove_Outermost_Parentheses__LC__1021 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/remove-outermost-parentheses/
        */
    }
    static class Solution {
        public String removeOuterParentheses(String s) {
            Stack<Character> st = new Stack<Character>();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(ch=='('){
                    if(st.size()>0)
                        sb.append(ch);
                    st.push(ch);
                }
                else{
                    st.pop();
                    if(st.size()>0)
                        sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}

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
import java.util.*;
/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
Example 3:

Input: s = "()"
Output: 0
Example 4:

Input: s = "()))(("
Output: 4
 
*/
public class Minimum_Add_to_Make_Parentheses_Valid__LC__921 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
        */
    }
    static class Solution {
        public int minAddToMakeValid(String S) {
            int count=0;
            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<S.length();i++){
                char ch=S.charAt(i);
                if(ch=='[' || ch=='{' || ch== '(')
                    st.push(S.charAt(i));
                else if(!st.isEmpty() && S.charAt(i)==')' && st.peek()=='(')
                    st.pop();
                else if(!st.isEmpty() && S.charAt(i)=='}' && st.peek()=='{')
                    st.pop();
                else if(!st.isEmpty() && S.charAt(i)==']' && st.peek()=='[')
                    st.pop();
                else
                    count++;

            }
            if(!st.isEmpty())
                count+=st.size();
            return count;
        }
    }
}

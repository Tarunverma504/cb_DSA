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
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 
*/

import java.util.*;
public class Minimum_Remove_to_Make_Valid_Parentheses__LC__1249 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
        */
    }
    static class Solution {
        public String minRemoveToMakeValid(String s) {
            char ch[]=s.toCharArray();
            Stack<Integer> st = new Stack<Integer>();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='(')
                    st.push(i);
                else if(ch[i]==')'){
                    if(st.isEmpty())
                        ch[i]='.';
                    else
                        st.pop();
                }

            }
            while(!st.isEmpty()){
                ch[st.pop()]='.';
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<ch.length;i++){
                if(ch[i]!='.')
                    sb.append(ch[i]);
            }
            return sb.toString();
        }
    }
}

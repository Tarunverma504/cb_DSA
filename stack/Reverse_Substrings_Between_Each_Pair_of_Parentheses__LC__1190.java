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
You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:
*/
import java.util.*;
public class Reverse_Substrings_Between_Each_Pair_of_Parentheses__LC__1190 {
    static class Solution {
        public String reverseParentheses(String s) {
            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<s.length();i++){
               if(s.charAt(i)==')'){
                   Queue<Character> q = new LinkedList<>();
                   while(st.peek()!='('){
                       q.add(st.pop());
                   }
                   st.pop();
                   while(!q.isEmpty()){
                       st.push(q.remove());
                   }
               }
               else{
                   st.push(s.charAt(i));
               }
            }
            String ans="";
            while(!st.isEmpty()){
                ans=st.pop()+ans;
            }
            return ans;
        }
    }
}

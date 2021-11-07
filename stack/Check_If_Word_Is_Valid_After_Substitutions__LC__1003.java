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
Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

 

Example 1:

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.
Example 2:

Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.
Example 3:

Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.
Example 4:

Input: s = "cababc"
Output: false
Explanation: It is impossible to get "cababc" using the operation.
 

Constraints:

1 <= s.length <= 2 * 104
s consists of letters 'a', 'b', and 'c'
*/
import java.util.*;
public class Check_If_Word_Is_Valid_After_Substitutions__LC__1003 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
        */
    }
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(ch=='c'){
                    if(st.size()>=2 && st.pop()=='b' && st.pop() =='a'){

                    }
                    else
                        return false;
                }
                else
                    st.push(ch);

            }

            return st.isEmpty();
        }
    }
}

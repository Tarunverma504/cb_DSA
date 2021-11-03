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
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 
*/

import java.util.*;
public class Remove_Duplicate_Letters__LC__316 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/remove-duplicate-letters/
        */
    }
    static class Solution {
        public String removeDuplicateLetters(String s) {
            int freq[] = new int[26];
            boolean visited[] = new boolean[26];
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                freq[ch-'a']++;
            }

            Stack<Character> st = new Stack<Character>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                freq[ch-'a']--;
                if(visited[ch-'a']) continue;
                while(!st.isEmpty() && st.peek()>ch && freq[st.peek()-'a']>0){
                    visited[st.peek()-'a']=false;
                    st.pop();

                }
                st.push(ch);
                visited[ch-'a']=true;
            }

            char arr[] = new char[st.size()];
            int n=arr.length-1;
            while(!st.isEmpty())
                arr[n--]=st.pop();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++)
                sb.append(arr[i]);
            return sb.toString();


        }
    }
}

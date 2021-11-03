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
Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
*/
import java.util.*;
public class Smallest_Subsequence_of_Distinct_Characters__LC__1081 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
        */
    }
    class Solution {
        public String smallestSubsequence(String s) {
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

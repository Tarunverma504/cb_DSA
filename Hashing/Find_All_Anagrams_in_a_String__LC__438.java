/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author Mind_Coder
 */
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
import java.util.*;
public class Find_All_Anagrams_in_a_String__LC__438 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/find-all-anagrams-in-a-string/
        */
    }
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if(s.length()<p.length())
                return ans;
            int pmap[] = new int[26];
            int smap[] = new int [26];
            for(int i=0;i<p.length();i++){
                pmap[p.charAt(i)-'a']++;
                smap[s.charAt(i)-'a']++;
            }
            int start=0;
            int end=p.length();
            while(end<s.length()){
                if(compare(pmap,smap)==true){
                    ans.add(start);
                }
                smap[s.charAt(end)-'a']++;
                smap[s.charAt(start)-'a']--;
                start++;
                end++;
            }
             if(compare(pmap,smap)==true){
                    ans.add(start);
            }
            return ans;
        }

        public static boolean compare(int[] pmap,int[] smap){
            for(int i=0;i<smap.length;i++){
                if(smap[i]!=pmap[i])
                    return false;
            }
            return true;
        }


    }
}

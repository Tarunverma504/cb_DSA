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
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
Accepted
323K
Submissions
719.1K
Seen this question in a real interview before?
*/

import java.util.*;
public class Permutation_in_String__LC__567 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/permutation-in-string/
        */
    }
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(s2.length()<s1.length())
                return false;
            int arr[] = new int[27];
            int brr[] = new int[27];
            for(int i=0;i<s1.length();i++){
                char ch = s1.charAt(i);
                arr[ch-'a']++;
            }
            int l=0;
            int r;
            for(r=0;r<s1.length();r++){
                char ch = s2.charAt(r);
                brr[ch-'a']++;
            }

            while(r<s2.length()){
                // System.out.println(r);
                if(check(arr, brr))
                    return true;
                brr[s2.charAt(l)-'a']--;
                brr[s2.charAt(r)-'a']++;
                r++;
                l++;

            }
            if(check(arr, brr))
                    return true;


            return false;
        }

        public static boolean check(int[] arr, int[] brr){
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=brr[i])
                    return false;

            }
            return true;
        }
    }
}

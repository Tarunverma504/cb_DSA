package DP;

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
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/
import java.util.*;
public class Minimum_Insertion_Steps_to_Make_a_String_Palindrome__LC__1312 {
 
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
        */
    }
    static class Solution {
        public int minInsertions(String s) {
            String t = reverse(s);
            if(s.equals(t))
                return 0;
            int lcs_len = lcs(s, t);
            return s.length()-lcs_len;
        }

        public int lcs(String s, String t){
            int tab[][] = new int[s.length()+1][t.length()+1];
            for(int i=0; i<tab.length; i++){
                tab[i][0]=0;
            }
            for(int j=0;j<tab[0].length;j++){
                tab[0][j]=0;
            }
            for(int i=1;i<tab.length;i++){
                for(int j=1;j<tab[0].length;j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        tab[i][j] = tab[i-1][j-1]+1;
                    }
                    else{
                        tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                    }
                }
            }
            return tab[s.length()][t.length()];
        }

        public String reverse(String s){
            StringBuilder sb = new StringBuilder();
            for(int i=s.length()-1; i>=0; i--){
                sb.append(s.charAt(i));
            }
            return new String(sb);
        }
    }
}

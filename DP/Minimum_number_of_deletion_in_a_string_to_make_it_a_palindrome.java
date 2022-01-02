/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Mind_Coder
 */
/*
Given a string of S as input. Your task is to write a program to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.
Note: The order of characters in the string should be maintained.

Example 1:

Input: S = "aebcbda"
Output: 2
Explanation: Remove characters 'e' 
and 'd'.
Example 2:

Input: S = "geeksforgeeks"
Output: 8
Explanation: One of the possible result
string can be "eefee", so answer is 
13 - 5 = 8.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumNumberOfDeletions() which takes the string S as inputs and returns the minimum number of deletions required to convert S into a pallindrome.

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

Constraints:
1 ≤ |S| ≤ 103
*/
public class Minimum_number_of_deletion_in_a_string_to_make_it_a_palindrome {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1#
        */
    }
    static class Solution{
        static int minimumNumberOfDeletions(String s) {
            //your code here
            String t  = reverse(s);
            int len_lcs = lcs(s, t);
            return s.length()-len_lcs;
        }

        public static int lcs(String s, String t){
            int tab[][] = new int[s.length()+1][t.length()+1];
            for(int i=0;i<tab.length;i++){
                for(int j=0;j<tab[0].length;j++){
                    if(i==0 || j==0)
                        tab[i][j]=0;
                }
            }

            for(int i=1; i<tab.length; i++){
                for(int j=1; j<tab[0].length; j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        tab[i][j]=tab[i-1][j-1]+1;
                    }
                    else{
                        tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                    }
                }
            }
            return tab[s.length()][t.length()];
        }

        public static String reverse(String s){
            StringBuilder sb = new StringBuilder();
            for(int i=s.length()-1; i>=0; i--){
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}

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
Given two sequences, print the longest subsequence present in both of them. 
Examples: 
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
We have discussed Longest Common Subsequence (LCS) problem in a previous post. The function discussed there was mainly to find the length of LCS. To find length of LCS, a 2D table L[][] was constructed. In this post, the function to construct and print LCS is discussed.
Following is detailed algorithm to print the LCS. It uses the same 2D table L[][].
1) Construct L[m+1][n+1] using the steps discussed in previous post.
2) The value L[m][n] contains length of LCS. Create a character array lcs[] of length equal to the length of lcs plus 1 (one extra to store \0).
2) Traverse the 2D array starting from L[m][n]. Do following for every cell L[i][j] 
…..a) If characters (in X and Y) corresponding to L[i][j] are same (Or X[i-1] == Y[j-1]), then include this character as part of LCS. 
…..b) Else compare values of L[i-1][j] and L[i][j-1] and go in direction of greater value.
The following table (taken from Wiki) shows steps (highlighted) followed by the above algorithm.
*/
import java.util.*;
public class Printing__Longest__Common__Subsequence___IMP {
    public static void main (String[] args)
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        lcs(X, Y, m, n);
    }
    
    public static void lcs(String x, String y,int m, int n){
        int l[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    l[i][j]=0;
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    l[i][j]=l[i-1][j-1]+1;
                }
                else{
                    l[i][j]=Math.max(l[i-1][j], l[i][j-1]);
                }
            }
        }
        
        print_lcs(x,y,m,n,l,l[m][n]);
    }
    public static void print_lcs(String x, String y,int m,int n, int[][] l,int len){
        char ch[]=new char[len];
        len--;
        int i=m;
        int j=n;
        while(i>0 && j>0){ 
            if(x.charAt(i-1)==y.charAt(j-1)){
                ch[len]=x.charAt(i-1); 
                i--;
                j--;
                len--;
            }
            else{
                if(l[i-1][j]>l[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        System.out.println(new String(ch));
    }
}

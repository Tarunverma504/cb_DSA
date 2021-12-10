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
Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.

Input Format
First line contains first string . Second line contains second string. Third line contains the third string.

Constraints
The length of all strings is |s|< 200

Output Format
Output an integer denoting the length of longest common subsequence of above three strings.

Sample Input
GHQWNV
SJNSDGH
CPGMAH
Sample Output
2
Explanation
"GH" is the longest common subsequence
*/
import java.util.*;
public class LCS_with_3_Strings__CB {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		int cache[][][] = new int[s1.length()][s2.length()][s3.length()];
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				for(int k=0;k<s3.length();k++){
					cache[i][j][k]=-1;
				}
			}
		}
		System.out.println(getResult(s1,0,s2,0,s3,0,cache));
    }
	public static int getResult(String s1,int cs1,String s2, int cs2,String s3,int cs3,int[][][] cache){
		if(cs1==s1.length() || cs2==s2.length() || cs3==s3.length())
			return 0;
		if(cache[cs1][cs2][cs3]!=-1)
			return cache[cs1][cs2][cs3];
		if(s1.charAt(cs1)==s2.charAt(cs2) && s2.charAt(cs2)==s3.charAt(cs3))
			return getResult(s1,cs1+1,s2,cs2+1,s3,cs3+1,cache)+1;
		else{
			int c1 = getResult(s1,cs1+1,s2,cs2,s3,cs3,cache);
			int c2 = getResult(s1,cs1,s2,cs2+1,s3,cs3,cache);
			int c3 = getResult(s1,cs1,s2,cs2,s3,cs3+1,cache);
			cache[cs1][cs2][cs3] = Math.max(c1,Math.max(c2,c3));
			return cache[cs1][cs2][cs3];
		}
	}
}

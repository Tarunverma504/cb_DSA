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
Any programmer worth his salt would be familiar with the famous Longest Common Subsequence problem. Mancunian was asked to solve the same by an incompetent programmer. As expected, he solved it in a flash. To complicate matters, a twist was introduced in the problem.

In addition to the two sequences, an additional parameter k was introduced. A k-ordered LCS is defined to be the LCS of two sequences if you are allowed to change atmost k elements in the first sequence to any value you wish to. Can you help Mancunian solve this version of the classical problem?

Input Format
The first line contains three integers N, M and k, denoting the lengths of the first and second sequences and the value of the provided parameter respectively. The second line contains N integers denoting the elements of the first sequence. The third line contains M integers denoting the elements of the second sequence.

Constraints
1 <= N, M <= 2000
1 <= k <= 5
1 <= element in any sequence <= 109

Output Format
Print the answer in a new line.

Sample Input
5 5 1
1 2 3 4 5
5 3 1 4 2
Sample Output
3
*/
import java.util.*;
public class K__Ordered_LCS__CB {
    public static void main (String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[m];
		int k=s.nextInt();
		for(int i=0;i<n;i++){
			arr1[i]=s.nextInt();
		}

		for(int i=0;i<m;i++){
			arr2[i]=s.nextInt();
		}
		int dp[][][]=new int[n+1][m+1][k+1];
		for(int[][] ar:dp){
			for(int[] kl:ar){
			Arrays.fill(kl,-1);
			}
		}
		int ans=callme(dp,arr1,arr2,0,0,k);
		System.out.println(ans);
	}
	public static int callme(int dp[][][],int arr1[],int arr2[],int i,int j,int k){
		if(i==arr1.length|| j==arr2.length)
			return 0;
		if(dp[i][j][k]!=-1)
			return dp[i][j][k];
		int c1=0,c2=0;
		if(arr1[i]==arr2[j]){
			c1=1+callme(dp,arr1, arr2, i+1, j+1,k);
		}
		if(k>0){
			c2=1+callme(dp,arr1, arr2, i+1, j+1,k-1);
		}
		int c3=Math.max(callme( dp, arr1, arr2, i+1, j,k),callme( dp, arr1, arr2, i, j+1,k));
		return dp[i][j][k]=Math.max(c1,Math.max(c2,c3)); 

	}
}

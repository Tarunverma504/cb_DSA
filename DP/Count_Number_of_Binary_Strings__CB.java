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
You are provided an integers N. You need to count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Input Format
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the the length of Binary String.

Constraints
1<=t<=100 1<=n<=90

Output Format
Print the number of all possible binary strings.

Sample Input
2
2
3
Sample Output
3
5
Explanation
1st test case : 00, 01, 10 2nd test case : 000, 001, 010, 100, 101
*/
import java.util.*;
public class Count_Number_of_Binary_Strings__CB {
    public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
			int n=s.nextInt();
			System.out.println(callme(n));
		}
	}	
	static long callme(int n){
		long a[]=new long[n+1];
		long b[]=new long[n+1];
		a[0]=b[0]=1;

		for(int i=1;i<n;i++){
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		return a[n-1]+b[n-1];
	}
}

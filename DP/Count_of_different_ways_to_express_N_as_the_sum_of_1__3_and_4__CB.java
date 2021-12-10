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
Given N, count the number of ways to express N as sum of 1, 3 and 4.

Input Format
First line contains the size of the array. Next line contains array elements.

Constraints
1 <= N <= 108

Output Format
Print the integer answer.

Sample Input
4
Sample Output
4 
Explanation
1+1+1+1
1+3
3+1
4
*/
import java.util.*;
public class Count_of_different_ways_to_express_N_as_the_sum_of_1__3_and_4__CB {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long cache[] = new long[n+1];
		Arrays.fill(cache,-1);
		System.out.println(getResult(n,cache));
    }

	public static long getResult(int n,long[] cache){
		if(n==0)
			return (long)1;
		if(n<0)
			return (long)0;
		if(cache[n]!=-1)
			return cache[n];
		long c1 = getResult(n-1,cache);
		long c2 = getResult(n-3,cache);
		long c3 = getResult(n-4,cache);
		cache[n] = c1+c2+c3;
		return cache[n];
	}
}

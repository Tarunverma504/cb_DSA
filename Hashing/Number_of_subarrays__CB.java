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
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Input Format
First line contains input N.
Next line contains a single integer k
Third contains N space separated integers denoting the elements of the array.

Constraints
1<= N <=100000

Output Format
print Number of subarrays having sum exactly equal to k

Sample Input
4 
0
0 0 0 0 
Sample Output
10
Explanation
None
*/
import java.util.*;
public class Number_of_subarrays__CB {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();
		}
		System.out.println(sol(arr,k));
    }

	public static long sol(long[] arr,long k){
		HashMap<Long, Long> hm = new HashMap<>();
		long currSum=0;
		long ans =0;
		for(int i=0;i<arr.length;i++){
			currSum+=arr[i];
			if(currSum==k)
				ans++;
			if(hm.containsKey(currSum-k)){
				ans+=hm.get(currSum-k);
			}
			Long count = hm.get(currSum);
            if (count == null)
                hm.put(currSum, (long)1);
            else
               hm.put(currSum, (long)count + 1);
		}
		return ans;
	}
}

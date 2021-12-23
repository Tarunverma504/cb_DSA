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

Given an array of n elements, check if the array contains any duplicates.
The function should return true if there are duplicates,otherwise return false.

Input Format
First line contains integer n as size of array.
Next line contains a n integer as element of array.

Constraints
None

Output Format
The output will be of the boolean form.

Sample Input
4
1 2 3 1
Sample Output
true
Explanation
*/
import java.util.*;
public class Duplicate_Values_I__CB {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(sol(arr));

    }
	public static boolean sol(int[] arr){
		HashSet<Integer> h = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			if(!h.add(arr[i])){
				return true;
				//System.out.println(arr[i]);
			}
				// return false;
		}
		return false;
		
	}
}

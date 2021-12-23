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
We are Given a target integer k and list of non-negative numbers.Write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

Input Format
First line contains list of integers. Second line contains the target k.

Constraints
1<=length of array<=10^4

Output Format
Print the boolean answer True/False.

Sample Input
[23,2,4,6,7]
6
Sample Output
True
Explanation
Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
*/
import java.util.*;
public class Multiple_in_continuous_subarray__CB {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		s = s.substring(1, s.length()-1);
		// System.out.println(s);
		String arr[] = s.split(",");
		System.out.println(sol(arr, n));
		// for(int i=0;i<arr.length;i++){
		// 	System.out.println(arr[i]);
		// }
    }

	public static String sol(String[] nums, int k){
		 Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if (map.get(remainder) + 1 < i) {
                    return "True";
                }
            } else {
                map.put(remainder, i);
            }
        }
        return "False";
	}
}

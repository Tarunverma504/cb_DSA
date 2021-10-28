/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Mind_Coder
 */
/*
Given an array, print the Next Greater Element (NGE) for every element. The Next Greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Input Format
First line of the input contains a single integer T denoting the number of testcases. First line of each testcase contains an integer N denoting the size of array. Second line of each testcase contains N space seperated integers denoting the array.

Constraints
1 <= T <= 50 1 <= N <= 10^5

Output Format
For each index, print its array element and its next greater element seperated by a comma in a new line.

Sample Input
2
4
11 13 21 3
5
11 9 13 21 3
Sample Output
11,13
13,21
21,-1
3,-1
11,13
9,13
13,21
21,-1
3,-1
Explanation
For the first testcase , the next greater element for 11 is 13 , for 13 its 21 and 21 being the largest element of the array does not have a next greater element. Hence we print -1 for 21. 3 is the last element of the array and does not have any greater element on its right. Hence we print -1 for it as well.
*/
import java.util.*;

public class Next_Greater_Element {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++)
				arr[i] = scn.nextInt();

			nextLarger(arr);

			t--;
		}

	}

	// Function to print Next Greater Element for each element of the array
	public static void nextLarger(int[] arr) {

// Write Code here
        Stack<Integer> st = new Stack<>();
        int n= arr.length; 
        int temp[] = new int[n];
        temp[n-1]=-1;
        st.push(arr[n-1]);
        for(int i=arr.length-2;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                temp[i]=-1;
            }
            else{
                temp[i]=st.peek();
            }
            st.push(arr[i]);
        }  
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+","+temp[i]);
        }    

	}
}

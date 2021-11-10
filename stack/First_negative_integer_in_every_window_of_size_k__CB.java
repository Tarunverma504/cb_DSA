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
import java.util.*;
/*
You are given given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Input Format
First line contains integer t as number of test cases. Each test case contains two lines. First line contains two integers n and k where n is length of the array and k is the size of window and second line contains n space separated integer.

Constraints
1 < t < 10 1< n, k < 10000000

Output Format
For each test case you have to print the required output as given below.

Sample Input
2
8 3
12 -1 -7 8 -15 30 16 28
 8 4
12 -1 -7 8 -15 30 16 28
Sample Output
-1 -1 -7 -15 -15 0 
-1 -1 -7 -15 -15
Explanation
For first test case : Subarray of window size 3 is ( 12 -1 -7), (-1, -7, 8), and so on.. Take first negative number from each window and print them.
*/
public class First_negative_integer_in_every_window_of_size_k__CB {
     public static void first_negative(int[] arr,int n,int k) throws Exception{ 
	
	// Write your Code here	
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k-1;i++){
			if(arr[i]<0)
				q.add(arr[i]);
		}
                for(int i=k-1;i<arr.length;i++){
			if(arr[i]<0)
				q.add(arr[i]);
			if(!q.isEmpty()){
				System.out.print(q.peek()+" ");
				if(q.peek()==arr[i-k+1])
					q.remove();
			}
			else
				System.out.print("0 ");

		}
                System.out.println();

    } 
     static Scanner scn = new Scanner(System.in);
     public static void main(String[] args) throws Exception {

        int t = scn.nextInt();
        
        while(t > 0){
		    int n = scn.nextInt();
		    int k = scn.nextInt();
		
		    int[] arr = new int[n];
		
		    for(int i = 0;i < n;i++){
		        arr[i] = scn.nextInt();
		    }
                    first_negative(arr,n,k);
		 
		t--;
	    }
		 
	}
     
                
}

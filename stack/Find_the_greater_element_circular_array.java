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
We are given a circular array, print the next greater number for every element. If it is not found print -1 for that number. To find the next greater number for element Ai , start from index i + 1 and go uptil the last index after which we start looking for the greater number from the starting index of the array since array is circular.

Input Format
First line contains the length of the array n. Second line contains the n space separated integers.

Constraints
1 <= n <= 10^6
-10^8 <= Ai <= 10^8 , 0<= i< n

Output Format
Print n space separated integers each representing the next greater element.

Sample Input
3
1 2 3
Sample Output
2 3 -1
Explanation
Next greater element for 1 is 2,
for 2 is 3 but not present for 3 therefore -1
*/
import java.util.*;
public class Find_the_greater_element_circular_array {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		int temp[]= new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(arr[arr.length-1]);
		temp[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--){
			while(!st.isEmpty() && arr[i]>=st.peek())
				st.pop();
			if(st.isEmpty())
				temp[i]=-1;
			else
				temp[i]=st.peek();
			st.push(arr[i]);
		}
		Stack<Integer> st2= new Stack<>();
		for(int i=0;i<arr.length;i++){
			if(temp[i]==-1){
				for(int j=0;j<i;j++){
					if(arr[j]>arr[i]){
						temp[i]=arr[j];
						break;
					}
						
				}
			}
		}

		for(int i=0;i<arr.length;i++){
			System.out.print(temp[i]+" ");
		}
    }
}


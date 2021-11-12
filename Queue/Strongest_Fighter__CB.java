/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Mind_Coder
 */
/*
There is a group of MMA fighters standing together in a line. Given the value of their strengths, find the strength of the strongest fighter in continuous sub-groups of size k.

Input Format
First line contains an integer N, the number of fighters Followed by N integers where i'th integer denotes the strength of i'th fighter. Next line contains the size of sub-group k

Constraints
1<=N<=10^7
1<=k<=N
1 <= Ai <= 100000

Output Format
Space separated integers in a single line denoting strength of strongest fighters in the groups.

Sample Input
5
1 3 1 4 5
3
Sample Output
3 4 5
Explanation
First sub-group: 1 3 1 --> Max strength is 3
Second sub-group: 3 1 4 --> Max strength is 4
Third sub-group: 1 4 5 --> Max strength is 5
*/
import java.util.*;
public class Strongest_Fighter__CB {
     public static void main(String args[]) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] =new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		k=k%n;
		Deque<Integer> q = new LinkedList<Integer>();

		for(int i=0;i<k;i++){
			while(!q.isEmpty() && arr[i]>=arr[q.peekLast()] ){
				q.removeLast();
			}
			q.addLast(i);
		}
		for(int i=k;i<n;i++){
			System.out.print(arr[q.peek()]+" ");
			while(!q.isEmpty() && i-k>=q.peek() ){
				q.removeFirst();
			}
			while(!q.isEmpty() && arr[i]>=arr[q.peekLast()] ){
				q.removeLast();
			}
			q.addLast(i);
		}
		System.out.print(arr[q.peek()]);
    }
}

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
Reverse a Queue using recursion.

Input Format
Enter the size of the queue N and N more number and store in the queue.

Constraints
None

Output Format
Display the values of the reversed queue.

Sample Input
3
1
2
3
Sample Output
3 2 1 END
*/
import java.util.*;
public class Reverse_a_Queue_Recursive__CB {
    public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			q.add(sc.nextInt());
		}

		reverse(q);
                while(!q.isEmpty()){
			System.out.print(q.remove()+" ");
		}
		System.out.print("END");
	}
    public static void reverse(Queue<Integer> q){
		if(q.isEmpty())
			return ;
		int x=q.remove();
		reverse(q);
		q.add(x);
	}
}

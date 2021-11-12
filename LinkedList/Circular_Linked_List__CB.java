/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Mind_Coder
 */

/*
We are given a linked list which contains a cycle. Detect that cycle and break it. Print the linked list after removing the cycle.

Input Format
The first line contains space separated integers. The integers are such that all the values are distinct but the value start repeating once the cycle gets completed. The list of integers given ends when -1 is input.

Constraints
n < 10^5 where n is the length of list without the cycle

Output Format
Output single line containing space separated integers representing the list

Sample Input
1 2 3 4 5 2 3 -1
Sample Output
1 2 3 4 5
Explanation
Initially the first five elements are unique but starts repeating from 2. This means there is a link from 5 back to 2. So it represents a cycle. We have to break this cycle and print the list after breaking the cycle.
*/
import java.util.*;
public class Circular_Linked_List__CB {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;
		} 
	}
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		Node head=null;
		while(true){
			int num=sc.nextInt();
			Node temp = new Node(num);
			if(num==-1)
				break;
			
			else if(head==null){
				head=temp;
			}
                        else{
				Node dummy=head;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;

			}
		}
		HashSet<Integer> h = new HashSet<Integer>();
		Node prev=null;
		Node temp=head;
		while(temp!=null){
			if(!h.add(temp.val)){
				prev.next=null;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
}

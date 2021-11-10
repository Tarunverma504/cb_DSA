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
Given a linked list with n nodes. Find the kth element from last without computing the length of the linked list.

Input Format
First line contains space separated integers representing the node values of the linked list. The list ends when the input comes as '-1'. The next line contains a single integer k.

Constraints
n < 10^5

Output Format
Output a single line containing the node value at the kth element from last.

Sample Input
1 2 3 4 5 6 -1
3
Sample Output
4
Explanation
The linked list is 1 2 3 4 5 6. -1 is not included in the list. So the third element from the last is 4
*/
import java.util.*;
public class Kth_element_from_last_in_linked_list__CB {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;	
		}
	}
	public static void main(String[] args) throws Exception {

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
                int k=sc.nextInt();
		// k=k%n;
		Node fast=head;
		Node slow=head;

		while(k-- > 0){
			fast=fast.next;
		}
                while(fast!=null){
			fast=fast.next;
			slow=slow.next;
		}
		System.out.println(slow.val);
	}

}

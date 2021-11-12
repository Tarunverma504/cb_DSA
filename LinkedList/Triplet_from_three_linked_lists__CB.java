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
Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given number say, Target. As any number of answers can be possible return the first one you get while traversing.

Input Format
The First Line contains 3 Integers n, m and k as the Size of the Three LinedLists. Next 3 Lines contains n, m and k integers Respectively as the elements of Linked Lists. Next Line contains the an Integer as Target.

Constraints
The Size of the Lists can be different.

Output Format
Display the 3 elements from each of the Lists whose sum is equals to the target separated by space.

Sample Input
3 3 3
12 6 29
23 5 8
90 20 59
101
Sample Output
6 5 90
Explanation
In the Given Sample Input, 6, 5 and 90 from lists 1, 2 and 3 respectively add to give 101.
*/
import java.util.*;
public class Triplet_from_three_linked_lists__CB {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;
		}
			
	}
    public static void main (String args[]) {

		Scanner sc = new Scanner(System.in);
		int n1= sc.nextInt();
		int n2= sc.nextInt();
		int n3=sc.nextInt();
		Node head1=null;
		Node head2=null;
		Node head3=null;
		for(int i=0;i<n1;i++){
			Node temp=new Node(sc.nextInt());
			if(head1==null)
				head1=temp;
			else{
				Node dummy=head1;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;
			}
		}

		for(int i=0;i<n2;i++){
			Node temp=new Node(sc.nextInt());
			if(head2==null)
				head2=temp;
			else{
				Node dummy=head2;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;
			}
		}
		for(int i=0;i<n3;i++){
			Node temp=new Node(sc.nextInt());
			if(head3==null)
				head3=temp;
			else{
				Node dummy=head3;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;
			}
		}

		int k=sc.nextInt();
		getnodes(head1,head2,head3,k);
		
    }

	public static void getnodes(Node head1,Node head2,Node head3,int k){

		while(head1!=null){
			if(head1.val<k){
				Node temp1=head2;
				while(temp1!=null){
					if((head1.val+temp1.val)<k){
						Node temp2=head3;
						while(temp2!=null){
							int sum=head1.val+temp1.val+temp2.val;
							if(sum==k){
								System.out.println(head1.val+" "+temp1.val+" "+temp2.val);
								return;
							}
							temp2=temp2.next;
						}
					}
					temp1=temp1.next;
				
				}
			}
			
			head1=head1.next;
		}
	}
}

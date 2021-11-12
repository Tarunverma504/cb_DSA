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
Given two numbers represented by two linked lists, write a program that prints the sum list. The sum list is linked list representation of addition of two input numbers in linked lists. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Use Recursion).

Input Format
First line contains N,M, number of nodes in the 1st and 2nd list.
Next line contains N nodes of 1st list.
Next line contains M nodes of 2nd list.

Constraints
0<N<10^6

Output Format
Print the sum list after adding the two linked lists.

Sample Input
3 3
5 6 3
8 4 2
Sample Output
1 4 0 5
Explanation
After adding the two numbers represented by linked lists i.e. 563 + 842 =1405 is represented as sum list. Sum list =1 -> 4 -> 0 -> 5.


*/
import java.util.*;
public class Sum_of_two_Linked_Lists_cb {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;
		}
	}
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		Node head1=null;
		for(int i=0;i<n1;i++){
			Node temp = new Node(sc.nextInt());
			if(head1==null){
				head1=temp;
			}
			else{
				Node dummy=head1;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;
			}
		}

		Node head2=null;
		for(int i=0;i<n2;i++){
			Node temp=new Node(sc.nextInt());
			if(head2==null)
				head2 = temp;
			else{
				Node dummy=head2;
				while(dummy.next!=null){
					dummy=dummy.next;
				}
				dummy.next=temp;
			}
		}

		

		if(n1>n2){
			int len =n1-n2;
			head2=addZero(head2,len);
		}
		else if(n2>n1){
			int len=n2-n1;
			head1=addZero(head1,len);
		}

		getSum(head1,head2);
		if(carry!=0){
			Node dummy=new Node(carry);
			dummy.next=head1;
			head1=dummy;
		}
		while(head1!=null){
			System.out.print(head1.val+" ");
			head1=head1.next;
		}
    }
	
	public static Node addZero(Node head,int len){
		for(int i=0;i<len;i++){
			Node dummy=new Node(0);
			dummy.next=head;
			head=dummy;

		}
		return head;

	}
	static int carry=0;
	public static void getSum(Node head1,Node head2){
		if(head1==null && head2==null){
			return;
		}
		getSum(head1.next,head2.next);
		int sum=head1.val + head2.val + carry;
		
		carry=sum/10;
		sum=sum%10;
		head1.val=sum;
		
	}
}



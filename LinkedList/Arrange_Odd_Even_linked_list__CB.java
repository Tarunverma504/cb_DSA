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

import java.util.*;
/*
We are Given a singly linked list, group all odd nodes together followed by the even nodes. Here we are talking about the node number and not the value in the nodes.
Note: i) You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
ii) The relative order inside both the even and odd groups should remain as it was in the input.
iii) The first node is considered odd, the second node even and so on

Input Format
First line contains the number of nodes n. Next line contains the n node numbers.

Constraints
1<=Length of linked list<=10^4

Output Format
Print the original list and the modified list after Grouping all odd nodes together followed by the even nodes.

Sample Input
10
1 2 3 4 5 6 7 8 9 10
Sample Output
Original List: 1 2 3 4 5 6 7 8 9 10 
Modified List: 1 3 5 7 9 2 4 6 8 10 
Explanation
None
*/
public class Arrange_Odd_Even_linked_list__CB {
    static class Node{
	int val;
	Node next=null;
	Node(int val){
	this.val=val;
	}
    }
    public static void main (String args[]) {
	Node head = null;
	Scanner sc=  new Scanner(System.in);
	int n=sc.nextInt();
        for(int i=0;i<n;i++){
		Node temp= new Node(sc.nextInt());
		if(head==null)
                    head=temp;
                    else{
			Node dummy=head;
			while(dummy.next!=null){
		        	dummy=dummy.next;
			}
			dummy.next=temp;
		    }
		}       
                Node t=head;
		System.out.print("Original List:");
		while(t!=null){
			System.out.print(" "+t.val);
			t=t.next;
		}
                Node oddh=head;
		Node evenh=head.next;
		Node odd=oddh;
		Node even=evenh;
                while(odd!=null && odd.next!=null && even!=null && even.next!=null){
			odd.next=odd.next.next;
			odd=odd.next;

			even.next=even.next.next;
			even=even.next;
		}
                odd.next=evenh;
		Node temp=oddh;
		
		System.out.println();
		System.out.print("Modified List:");
		while(temp!=null){
			System.out.print(" "+temp.val);
			temp=temp.next;
		}
    }
}

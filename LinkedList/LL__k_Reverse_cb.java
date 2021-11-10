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
Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the size of List.

You need not have to create a new list. Just reverse the old one using head.

Input Format
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Constraints
0 <= N <= 10^6 0 <= K <= 10^6

Output Format
Display the linkedlist after reversing every k elements

Sample Input
9 3
9 4 1 7 8 3 2 6 5
Sample Output
1 4 9 3 8 7 5 6 2
Explanation
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
*/
import java.util.*;
public class LL__k_Reverse_cb {
    static class Node{
	int val;
	Node next=null;
	Node(int val){
	    this.val=val;
	}
    }
    public static void main(String arg[]){
	Node head=null;
	Scanner sc= new Scanner(System.in);
	int n=sc.nextInt();
	int k=sc.nextInt();
	for(int i=0;i<n;i++){
            Node temp=new Node(sc.nextInt());
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
		Node ans=reversek(head,k);
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans=ans.next;
		}
                }

	public static Node reversek(Node head,int k){
		if(head==null)
			return null;
		Node kplus1=head;
                for(int i=0;i<k;i++){
			if(kplus1==null)
				return head;
			kplus1=kplus1.next;
		}
		Node newhead=actualreverse(head,kplus1);
		head.next=reversek(kplus1,k);
		return newhead;
                }
	public static Node actualreverse(Node head,Node kplus1){
		Node curr=head;
		Node prev=null;
		while(curr!=kplus1){
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
                return prev;
	}
                }


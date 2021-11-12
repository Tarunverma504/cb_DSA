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
There are two linked lists. Due to some programming error, the end node of one of the linked list got linked into the second list, forming an inverted Y shaped list. Now it's your job to find the point(Node) at which the two linked lists are intersecting.

Input Format
The first line of input is the size(N1) of the first linked list, followed by its content(Xi). The third line of input is the size(N2) of the second linked list, followed by its content( Yi ).

Constraints
1<=N, N2<=100 0<=Xi, Yi<=100

Output Format
A single integer denoting the intersection point of two linked lists. If the linked lists are not intersecting at any point then print -1.

Sample Input
5
10 20 30 40 50
4
15 25 40 50
Sample Output
40
Explanation
First and second linked list intersect at the node whose data value is 40.
*/
import java.util.*;
public class Intersection_point_two_linked_lists__CB {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;
		}
    }
    
    public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		Node head1 = null;
		int n1= sc.nextInt();
		while(n1-- > 0){
			Node temp = new Node(sc.nextInt());
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

		Node head2=null;
        int n2=sc.nextInt();
		while(n2-- > 0){
			Node temp = new Node(sc.nextInt());
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

		int len1=len(head1);
		int len2=len(head2);
		if(len1>len2){
			for(int i=0;i<len1-len2;i++){
				head1=head1.next;
			}
		}
		else{
			for(int i=0;i<len2-len1;i++){
				head2=head2.next;
			}
		}
		int ans=-1;
		while(head1!=null && head2!=null){
			if(head1.val==head2.val){
				ans=head1.val;
				break;
			}
			head1=head1.next;
			head2=head2.next;
		}
		System.out.println(ans);
	}

	public static int len(Node head){
		int count=0;
		while(head!=null){
			count++;
			head=head.next;
		}
		return count;
	}
}

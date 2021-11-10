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
Given 2 sorted linked lists , merge the two given sorted linked list and print the final Linked List.

Input Format
First Line contains T the number of test cases.
For each test case :
Line 1 : N1 the size of list 1
Line 2 : N1 elements for list 1
Line 3 : N2 the size of list 2
Line 4 : N2 elements for list 2

Constraints
1 <= T <= 1000
0<= N1, N2 <= 10^6
-10^7 <= Ai <= 10^7

Output Format
For each testcase , print the node data of merged linked list.

Sample Input
1
4
1 3 5 7
3
2 4 6
Sample Output
1 2 3 4 5 6 7 
Explanation
The two lists after merging give the sorted output as [1,2,3,4,5,6,7] .
*/
import java.util.*;
public class Merge_Sorted_Linked_Lists {
    static class Node{
		int val;
		Node next=null;
		Node(int data){
			this.val=data;
		}
	}
	public static void main(String[] args) throws Exception {
			
			Scanner sc = new Scanner(System.in);
			int t=sc.nextInt();

			while(t-- > 0){ 
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

				Node result=merging(head1,head2);
                                while(result!=null){
					System.out.print(result.val+" ");
					result=result.next;
				}
				System.out.println();

			}
        }
        public static Node merging(Node head1,Node head2){
		Node ans= new Node(-1);
		Node head3=ans;
		while(head1!=null && head2!=null){
			if(head1.val<=head2.val){
				ans.next=head1;
				head1=head1.next;
			}
			else{
				ans.next=head2;
				head2=head2.next;
			}
			ans=ans.next;
		}
		if(head1!=null){
			ans.next=head1;
                        }
		if(head2!=null){
			ans.next=head2;
		}
		return head3.next;
	}
}

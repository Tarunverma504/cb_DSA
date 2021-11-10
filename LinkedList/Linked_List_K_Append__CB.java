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
Given a linked list of length N and an integer K , append the last K elements of a linked list to the front. Note that K can be greater than N.

Input Format
First line contains a single integer N denoting the size of the linked list.
Second line contains N space separated integers denoting the elements of the linked list.
Third line contains a single integer K denoting the number of elements that are to be appended.

Constraints
1 <= N <= 10^4
1 <= K <= 10^4

Output Format
Display all the elements in the modified linked list.

Sample Input
7
1 2 2 1 8 5 6
3
Sample Output
8 5 6 1 2 2 1
Explanation
Initially the linked list is
1→ 2→ 3 → 4 → 5 → 6→ null
and k = 2. After appending the last two elements to the front , the new linked list looks like
5→ 6→ 1→ 2→ 3 → 4 → null
*/
import java.util.*;
public class Linked_List_K_Append__CB {
    static class Node {
		int val;
		Node next=null;

		Node(int data) {
			this.val = data;
		}
	}
    public static void main(String arg[]){
		Node head=null;
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			Node temp = new Node(sc.nextInt());
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
                int k=sc.nextInt();
		k=k%n;
		Node slow=head;
		Node fast=head;
		while(k>0){
			fast=fast.next;
			k--;
		}
                while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
                while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
    }

}

package LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]
 

Constraints:

The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 

Follow-up: Can you solve the problem in O(1) extra memory space?
*/
public class Reverse_Nodes_in_k_Group__LC__25 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/reverse-nodes-in-k-group/
        */
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode reverseActual(ListNode head,ListNode kplus1){
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=kplus1){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            return prev;
        }

        public ListNode reverseKGroup(ListNode head, int k) {

            if(head==null)
                return null;
            ListNode kplus1=head;
            for(int i=0;i<k;i++){
                if(kplus1==null)
                    return head;
                kplus1=kplus1.next;
            }
             ListNode newhead=reverseActual(head,kplus1);
                head.next=reverseKGroup(kplus1,k);
            return newhead;
        }
    }
}

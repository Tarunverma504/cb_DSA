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
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
Accepted
1.1M
Submissions
2.4M
*/

import java.util.*;
public class Merge_k_Sorted_Lists__LC__23 {
    
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/merge-k-sorted-lists/
        */
    }
    static class Solution {
         public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){;
                   public int compare(ListNode l1, ListNode l2){
                       return l1.val-l2.val;
                   }                                                                    
            });

            for(int i=0;i<lists.length;i++){
                ListNode node = lists[i];
                while(node!=null){
                    q.add(node);
                    node=node.next;
                }
            }


            ListNode head = new ListNode(-1);
            ListNode ans = head;
            while(!q.isEmpty()){
                ListNode dummy = new ListNode(q.remove().val);
                ans.next = dummy;
                ans = ans.next;
            }
            return head.next;


        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Mind_Coder
 */
/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

Accepted
687,674
Submissions
1,041,999
*/
import java.util.*;
public class Kth_Smallest_Element_in_a_BST__LC__230 {
   
 public static void main(String arg[]){
     /*
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     */
 }
static class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        sol(root,inorder);
        return inorder.get(k-1);
    }
    
    public static void sol(TreeNode root,List<Integer> inorder){
        if(root==null)
            return;
        sol(root.left,inorder);
        inorder.add(root.val);
        sol(root.right,inorder);
        
    }
}
}

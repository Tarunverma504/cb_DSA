/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Tree;

/**
 *
 * @author Mind_Coder
 */

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [2,1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.*;
public class Binary_Tree_Postorder_Traversal__LC__145 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/binary-tree-postorder-traversal/
        */
    }
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
    static class Solution {
    public static List<Integer> ans;
        public List<Integer> postorderTraversal(TreeNode root) {
            ans=new ArrayList<Integer>();
            getResult(root);
            return ans;
        }

        public static void getResult(TreeNode root){
            if(root==null)
                return ;

            getResult(root.left);
            getResult(root.right);
            ans.add(root.val);
        }
    }
}

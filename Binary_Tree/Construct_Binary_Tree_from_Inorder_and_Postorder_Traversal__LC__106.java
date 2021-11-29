package Binary_Tree;

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
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
*/
import java.util.*;
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal__LC__106 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
        */
    }
    public static  class TreeNode {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int psi=0;
            int pei = postorder.length-1;
            int isi = 0;
            int iei = inorder.length-1;

            return buildTree(inorder,isi,iei,postorder,psi,pei);
        }

        public TreeNode buildTree(int[] inorder, int isi, int iei, int[] postorder, int psi,int pei){

            if(isi > iei)
                return null;

            int idx = isi;
            while(inorder[idx]!= postorder[pei])
                    idx++;

            int tnel = idx-isi;
            TreeNode node = new TreeNode(inorder[idx]);
            node.left = buildTree(inorder, isi, idx-1, postorder, psi, psi+tnel-1 );
            node.right = buildTree(inorder, idx+1, iei, postorder, psi+tnel, pei-1);
            return node;


        }
    }
}

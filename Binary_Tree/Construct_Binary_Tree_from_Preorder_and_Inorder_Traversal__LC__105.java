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
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
*/
import java.util.*;
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal__LC__105 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int psi = 0;  //preorder starting index
            int pei = preorder.length-1;  //preorder ending index
            int isi = 0;  //inorder starting index
            int iei = inorder.length-1;  //inorder ending index

            return buildTree(preorder, psi, pei, inorder, isi, iei);
        }

        public TreeNode buildTree(int[] preorder, int psi, int pei,int[] inorder, int isi, int iei){

            if(isi>iei)
                return null;
            int idx = isi;
            while(inorder[idx]!=preorder[psi])
                idx++;
            int clse = idx-isi; //clse count of the left subtree element
            TreeNode node = new TreeNode(preorder[psi]);
            node.left = buildTree(preorder, psi+1, pei+clse, inorder, isi, idx-1);
            node.right = buildTree(preorder, psi+clse+1, pei, inorder, idx+1, iei);

            return node;


        }
    }
}

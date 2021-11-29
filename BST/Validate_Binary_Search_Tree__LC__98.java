package Binary_Tree.BST;

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
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

*/
import java.util.*;
public class Validate_Binary_Search_Tree__LC__98 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/validate-binary-search-tree/
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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        public static boolean isValidBST(TreeNode root,long minRange,long maxRange){
            if(root==null)
                return true;
            if(root.val<=minRange || root.val>=maxRange)
                return false;
            boolean isLeftBst = isValidBST(root.left,minRange,root.val);
            boolean isRightBst = isValidBST(root.right,root.val,maxRange);
            return isLeftBst && isRightBst;
        }
    }
}

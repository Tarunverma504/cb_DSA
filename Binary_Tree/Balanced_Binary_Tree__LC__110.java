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
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/
import java.util.*;
public class Balanced_Binary_Tree__LC__110 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/balanced-binary-tree/
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
        public boolean isBalanced(TreeNode root) {

            if(root==null)
                return true;

            int leftHeight = Height(root.left);
            int rightHeight = Height(root.right);

            boolean isRootBalanced = Math.abs(leftHeight-rightHeight)<=1;
            boolean isLeftBalanced = isBalanced(root.left);
            boolean isRightBalanced = isBalanced(root.right);
            return isRootBalanced && isLeftBalanced && isRightBalanced;
        }
        public static int Height(TreeNode root){
            if(root==null)
                return 0;
            int left = Height(root.left);
            int right = Height(root.right);
            return Math.max(left,right)+1;
        }
    }
}

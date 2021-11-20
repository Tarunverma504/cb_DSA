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
public class Invert_Binary_Tree__LC__226 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/invert-binary-tree/
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
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null)
                return null;
            TreeNode lSubtree = invertTree(root.left);
            TreeNode rSubtree = invertTree(root.right);
            root.left=rSubtree;
            root.right=lSubtree;
            return root;
        }
    }
}

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
public class Minimum_Depth_of_Binary_Tree__LC__111 {
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
        public int minDepth(TreeNode root) {
            if(root==null){
                        return 0;
                    }
                    int left=minDepth(root.left);
                    int right=minDepth(root.right);
                    if(left==0 || right==0){    //this is for if the tree is one sided
                        return Math.max(left,right)+1;
                    }
                    return Math.min(left,right)+1;
        }
    }
}

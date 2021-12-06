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
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0
*/
import java.util.*;
public class Binary_Tree_Cameras__LC__968 {
    public static void msin(String arg[]){
        /*
            https://leetcode.com/problems/binary-tree-cameras/
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

        public static int camera;
        public int minCameraCover(TreeNode root) {
            camera=0;
            if(getResult(root)==-1)
                camera++;
            return camera;
        }

        public static int getResult(TreeNode root){
            if(root==null)
                return 1;
            int left = getResult(root.left);
            int right = getResult(root.right);
            if(left==-1 || right==-1){
                camera++;
                return 0;
            }
            if(left==0 || right==0)
                return 1;
            return -1;
        }
    }
}

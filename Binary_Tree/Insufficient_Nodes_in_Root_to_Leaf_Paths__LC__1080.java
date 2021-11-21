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
Given the root of a binary tree and an integer limit, delete all insufficient nodes in the tree simultaneously, and return the root of the resulting binary tree.

A node is insufficient if every root to leaf path intersecting this node has a sum strictly less than limit.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
Output: [1,2,3,4,null,null,7,8,9,null,14]
Example 2:


Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
Output: [5,4,8,11,null,17,4,7,null,null,null,5]
Example 3:


Input: root = [1,2,-3,-5,null,4,null], limit = -1
Output: [1,null,-3,4]
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
-105 <= Node.val <= 105
-109 <= limit <= 109
*/
import java.util.*;
public class Insufficient_Nodes_in_Root_to_Leaf_Paths__LC__1080 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
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
        public TreeNode sufficientSubset(TreeNode root, int limit) {

            return(pathSum(root,limit,0)==false?null:root );

        }

        public static boolean pathSum(TreeNode root,int limit,int csum ){

            if(root==null)
                return false;
            if(root.left==null && root.right==null){
                if(csum+root.val<limit)
                    return false;
                return true;
            }

            boolean leftAns = pathSum(root.left, limit, csum+root.val);
            boolean rightAns = pathSum(root.right, limit, csum+root.val);

            if(leftAns==false && rightAns==false){
                return false;
            }

            if(leftAns==false){
                root.left=null;
            }
            if(rightAns==false){
                root.right=null;
            }

            return true;
        }
    }
}

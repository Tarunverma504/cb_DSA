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
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

*/
import java.util.*;
public class Symmetric_Tree__LC__101 {
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
        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;
            return isSymmetric(root.left,root.right);
        }

        public boolean isSymmetric(TreeNode t1, TreeNode t2){
            if(t1==null && t2==null)
                return true;
            if(t1==null || t2==null)
                return false;
            if(t1.val!=t2.val)
                return false;
            boolean ans1 = isSymmetric(t1.right, t2.left);
            boolean ans2 = isSymmetric(t1.left,t2.right);
            return ans1 && ans2;
        } 
    }
}

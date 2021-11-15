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
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Example 3:

Input: root = [1,2], targetSum = 0
Output: false
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
import java.util.*;
public class Path_Sum__LC__112 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/path-sum/
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            boolean ans=getSum(root,targetSum,0);
            return ans;
        }

        public static boolean getSum(TreeNode root, int targetSum, int csum){

            if(root==null)
                return false;
            if(root.left==null && root.right==null){
                if(root.val+csum==targetSum)
                    return true;
            }

            boolean leftans = getSum(root.left, targetSum, csum+root.val);
            boolean rightans = getSum(root.right, targetSum, csum+root.val);
             return leftans||rightans;

        }
    }
}

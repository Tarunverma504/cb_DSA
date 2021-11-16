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
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

import java.util.*;
public class Path_Sum_II__LC__113 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/path-sum-ii/
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp=new ArrayList<>();
            int csum=0;
            pathSum(root, targetSum, temp, ans, csum);
            return ans;
        }

        public void pathSum(TreeNode root, int targetSum,   List<Integer> temp, List<List<Integer>> ans, int csum){

            if(root==null)
                return;
            if(root.left==null && root.right==null){
                if(csum+root.val == targetSum){
                    temp.add(root.val);
                    ans.add(new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                    return;
                }

            }

            temp.add(root.val);
            pathSum(root.left, targetSum, temp, ans, csum+root.val);
            pathSum(root.right, targetSum, temp, ans, csum+root.val);
            temp.remove(temp.size()-1);
            return;
        }
    }
}

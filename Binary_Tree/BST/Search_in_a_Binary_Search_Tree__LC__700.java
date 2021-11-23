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
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
Accepted
350,941
Submissions
471,564
*/
import java.util.*;
public class Search_in_a_Binary_Search_Tree__LC__700 {
    
     public static void main(String arg[]){
        /*
            https://leetcode.com/problems/search-in-a-binary-search-tree/
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
        public TreeNode searchBST(TreeNode root, int val) {
            if(root==null){
                return null;
            }

             if(root.val==val){
                 return root;
             }

            if(root.val<val){
                return searchBST(root.right,val);
            }            
            else{
                return searchBST(root.left,val);
            }

        }
    }
}

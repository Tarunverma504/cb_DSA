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
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
*/
import java.util.*;
public class Lowest_Common_Ancestor_of_a_Binary_Tree__LC__236 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        */
    }
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root==null)
                return null;
            if(root==p || root==q)
                return root; //return the node whose value matched with p or q

            TreeNode leftAns = lowestCommonAncestor(root.left,p,q);  //search for p or q in left subtree
            TreeNode rightAns = lowestCommonAncestor(root.right,p,q);  //search for p or q in right subtree
            if(leftAns!=null && rightAns!=null)
                return root;  //it means we find the both p and q and this is the lca
            if(leftAns!=null)
                return leftAns;  //it mean we find p or q in left subtree so we return that node
            return rightAns;   //it mean we find p or q in right subtree so we return that node


        }
    }
}

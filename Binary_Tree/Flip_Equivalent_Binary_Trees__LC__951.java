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
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

 

Example 1:

Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Example 2:

Input: root1 = [], root2 = []
Output: true
Example 3:

Input: root1 = [], root2 = [1]
Output: false
Example 4:

Input: root1 = [0,null,1], root2 = []
Output: false
Example 5:

Input: root1 = [0,null,1], root2 = [0,1]
Output: true
 

Constraints:

The number of nodes in each tree is in the range [0, 100].
Each tree will have unique node values in the range [0, 99].
*/
import java.util.*;
public class Flip_Equivalent_Binary_Trees__LC__951 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/flip-equivalent-binary-trees/
        */
    }
    static public class TreeNode {
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
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if(root1==null && root2==null)
                return true;
            if(root1==null || root2==null)
                return false;
            if(root1.val!=root2.val)
                return false;
            boolean comp1 = flipEquiv(root1.left,root2.right);
            boolean comp2 = flipEquiv(root1.right,root2.left);
            boolean comp3 = flipEquiv(root1.left,root2.left);
            boolean comp4 = flipEquiv(root1.right,root2.right);
            if((comp1==true && comp2==true) || (comp3==true && comp4==true))
                return true;
            return false;
        }
    }
}

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
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
Accepted
601,542
Submissions
1,146,518
*/
import java.util.*;
public class Diameter_of_Binary_Tree__LC__543OPTIMIZED {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/diameter-of-binary-tree/
        */
    }
    static class Solution {
    
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
        
        public static class Pair{
            int height;
            int diameter;
            Pair(int h,int d){
                this.height=h;
                this.diameter=d;
            }
        }

        public int diameterOfBinaryTree(TreeNode root) {

            Pair ans=diameterOpt(root);
            return ans.diameter;
        }

        public static Pair diameterOpt(TreeNode root){
            if(root==null){
                return (new Pair(0,0));
            }

            Pair leftPair = diameterOpt(root.left);
            Pair rightPair = diameterOpt(root.right);

            int leftHeight = leftPair.height;
            int rightHeight = rightPair.height;

            int apnaDia = leftHeight+rightHeight;
            int apniHeight =  Math.max(leftHeight, rightHeight)+1;

            int finalDia = Math.max(apnaDia,Math.max(leftPair.diameter, rightPair.diameter));
            return new Pair(apniHeight,finalDia);

        }
    }
}

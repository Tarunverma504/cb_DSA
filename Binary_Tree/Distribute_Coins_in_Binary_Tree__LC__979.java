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
You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.

Return the minimum number of moves required to make every node have exactly one coin.

 

Example 1:


Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
Example 2:


Input: root = [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
Example 3:


Input: root = [1,0,2]
Output: 2
Example 4:


Input: root = [1,0,0,null,3]
Output: 4
 

Constraints:

The number of nodes in the tree is n.
1 <= n <= 100
0 <= Node.val <= n
The sum of all Node.val is n.
*/
public class Distribute_Coins_in_Binary_Tree__LC__979 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/distribute-coins-in-binary-tree/
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
    static int moves;
        public int distributeCoins(TreeNode root) {
            moves =0;
            getResult(root);
            return moves;
        }

        public static int getResult(TreeNode root){
            if(root==null)
                return 0;
            int left = getResult(root.left);
            int right = getResult( root.right);
            moves+=Math.abs(left)+Math.abs(right);
            return root.val + left + right - 1;
        }
    }
}

package DP;

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
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:


Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:


Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104
*/
public class House_Robber_III__LC__337 {

    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/house-robber-iii/
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
    public static class Pair{
        int with_rob;
        int without_rob;
        Pair(int with_rob, int without_rob){
            this.with_rob = with_rob;
            this.without_rob = without_rob;
        }
    }
    public int rob(TreeNode root) {
        Pair ans = getResult(root);
        return Math.max(ans.with_rob,ans.without_rob);
    }
    
    public static Pair getResult(TreeNode root){
        if(root==null)
            return new Pair(0,0);
        Pair left = getResult(root.left);
        Pair right = getResult(root.right);
        Pair myAns = new Pair(0,0);
        myAns.with_rob = left.without_rob + right.without_rob + root.val;
        myAns.without_rob = Math.max(left.with_rob,left.without_rob)+Math.max(right.with_rob,right.without_rob);
        return myAns;
    }
}
}

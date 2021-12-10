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
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100
*/
import java.util.*;
public class Longest_ZigZag_Path_in_a_Binary_Tree__LC__1372 {
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
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
        */
    }
    
    /*
        (root)              forward/       backward\
         /  \
    (left)   (right)


    at left side we see backward slash to get zigzag path
    at right side we see forward slash to get zigzag path
    */
    static class Solution {
        static class Pair{
            int forward_Slope = -1;  //store the length of zigzag path at forward slope
            int backward_Slope = -1; // store the length of zigzag path at backward slope
            int maxLen = 0; // store the maxlength of the zigzag path till now
            Pair(int f,int b,int l){
                this.forward_Slope = f;
                this.backward_Slope = b;
                this. maxLen = l;
            }
        }
        public int longestZigZag(TreeNode root) {
            Pair ans = getResult(root);
            return ans.maxLen;
        }

        public static Pair getResult(TreeNode root){

            if(root==null)
                return (new Pair(-1,-1,0));  //snce there i no and left substree and right subtree so we return -1 -1 0
            Pair left = getResult(root.left);
            Pair right = getResult(root.right);
            Pair myAns = new Pair(-1,-1,0);

            //to find the maxlen with respect to current node we find the of the maxlen in left subtree and in right subtree then we find the max of the len of the left backward slope and len of the right forward slope and add 1 to it consider if we add current node in it and finally we tak max of the maxlen and the slopes by this we get maxlen zigzag till curretn node
            myAns.maxLen = Math.max(Math.max(left.maxLen,right.maxLen),Math.max(left.backward_Slope,right.forward_Slope)+1);
            myAns.forward_Slope = left.backward_Slope + 1; //to get zigzag path we add 1 to backward sope of left for current node;
            myAns.backward_Slope = right.forward_Slope + 1;// to get zigzag path for backward slope we add 1 to the forward slope of the rightfor current node
            return myAns;


        }
    }
}
 
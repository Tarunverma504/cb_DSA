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
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
*/
import java.util.*;
public class Sum_Root_to_Leaf_Numbers__LC__129 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    static int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        getSum(root,0);
        return sum;
    }
    
    public void getSum(TreeNode root,int temp){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            
            temp = temp*10+root.val;
            sum+=temp;
            return;
        }
        
        getSum(root.left, temp*10+root.val);
        getSum(root.right, temp*10+root.val);
    }
}
}

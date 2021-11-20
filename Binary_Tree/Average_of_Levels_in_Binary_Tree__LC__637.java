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
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:


Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
Accepted
231,727
Submissions
343,120
*/
import java.util.*;
public class Average_of_Levels_in_Binary_Tree__LC__637 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<Double> ans = new LinkedList<>();
            if(root==null)
                return ans;
            q.add(root);
            while(!q.isEmpty()){
                int n =q.size();
                int x=n;
                double sum=0;
                while(n-- > 0){
                    TreeNode node = q.poll();
                    sum+=(double)node.val;
                    if(node.left!=null)
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);
                }
                sum=sum/x;
                ans.add(sum);

            }
            return ans;
        }
    }
}

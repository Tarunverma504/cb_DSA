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
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/
import java.util.*;
public class Binary_Tree_Zigzag_Level_Order_Traversal__LC__103 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int count=0;
	    Queue<TreeNode> q = new LinkedList<>();
	    List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
	    q.add(root);
	    while(!q.isEmpty()){
	        int n=q.size();
	        ArrayList<Integer> temp = new ArrayList<>();
	        count++;
	        while(n-- > 0){
	            
	            TreeNode node=q.poll();
                if(count%2==0){
                    // temp.addFirst(node.val);
                    temp.add(0, node.val);
                }
                else
	                temp.add(node.val);
	            if(node.left!=null){
	                q.add(node.left);
	            }
	            if(node.right!=null){
	                q.add(node.right);
	            }
	        }
            ans.add(temp);
	    }
	    return ans;
    }
}
}

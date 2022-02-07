/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Tree;

/**
 *
 * @author Mind_Coder
 */
/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.
 

Constraints:

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
*/
import java.util.*;
public class Count_Good_Nodes_in_Binary_Tree__LC__1448 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/count-good-nodes-in-binary-tree/
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
        static int good;
        public int goodNodes(TreeNode root) {
            good=0;
            sol(root,Integer.MIN_VALUE);
            return good;
        }
        public static void sol(TreeNode root,int max){
            if(root==null)
                return;
            if(root.val>=max)
                good++;
            max=Math.max(max,root.val);
            sol(root.left,max);
            sol(root.right,max);
        }
    }
}

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
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
*/
import java.util.*;
public class Recover_Binary_Search_Tree__LC__99 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/recover-binary-search-tree/
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
        static TreeNode first,mid,last,prev;
        public void recoverTree(TreeNode root) {

            first=null;
            mid=null;
            last=null;
            prev=null;

            getNodes(root);
            TreeNode a =null;
            TreeNode b = null;
            if(first!=null && last!=null){
                a=first;
                b=last;
            }
            else if(first!=null && mid!=null){
                a=first;
                b=mid;
            }
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
        public static void getNodes(TreeNode root){
            if(root==null)
                return;
            getNodes(root.left);

            if(prev!=null && prev.val > root.val){
                if(first==null){
                    first = prev;
                    mid = root;
                }
                else{
                    last = root;
                }
            }
            prev =  root;

            getNodes(root.right);
        }

    }
}

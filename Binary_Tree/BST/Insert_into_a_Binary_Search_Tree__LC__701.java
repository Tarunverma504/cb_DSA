package Binary_Tree.BST;

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
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
*/
import java.util.*;
public class Insert_into_a_Binary_Search_Tree__LC__701 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/insert-into-a-binary-search-tree/
        */
    }
    public static  class TreeNode {
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null)
            {
                TreeNode nn = new TreeNode(val);
                    root=nn;
            }
            else{
                insert(root,val);
            }

            return root;
        }

        public void insert(TreeNode root, int val){
            if(val<root.val){
                if(root.left!=null)
                    insert(root.left,val);
                else{
                    TreeNode nn = new TreeNode(val);
                    root.left=nn;
                }

            }
            else if(val>root.val){
                if(root.right!=null)
                    insert(root.right,val);
                else{
                    TreeNode nn = new TreeNode(val);
                    root.right=nn;
                }

            }
        }
    }
}

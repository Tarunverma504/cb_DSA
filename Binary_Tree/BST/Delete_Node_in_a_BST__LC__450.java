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
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
*/
import java.util.*;
public class Delete_Node_in_a_BST__LC__450 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/delete-node-in-a-bst/
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
        public TreeNode deleteNode(TreeNode root, int key) {

            if(root==null)
                return null;
            if(key<root.val){
                root.left = deleteNode(root.left,key);
            }
            else if(key>root.val){
                root.right = deleteNode(root.right,key);
            }
            else{
                //if delete node is leaf node
                if(root.left==null && root.right==null)
                    return null;
                // if there is child at left side
                else if(root.right==null)
                    return root.left;
                // if there is child at right side
                else if(root.left==null)
                    return root.right;
                 //find the just min node of the child of delete node
                //and swap the value of the delte node with min node and the delete the min leaf node;
                else{
                    int inOrderSuccessor = min(root.right);
                    root.val=inOrderSuccessor;
                    root.right = deleteNode(root.right,inOrderSuccessor);
                }

            }
            return root;


        }

        public static int min(TreeNode root){
            if(root.left==null)
                return root.val;
            return min(root.left);
        }
    }
}

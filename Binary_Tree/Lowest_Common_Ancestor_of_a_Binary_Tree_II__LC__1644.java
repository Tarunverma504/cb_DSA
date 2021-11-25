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
Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1Output: 3Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4Output: 5Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.
Example 3:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10Output: nullExplanation: Node 10 does not exist in the tree, so return null.
Constraints:
The number of nodes in the tree is in the range [1, 104].-109 <= Node.val <= 109All Node.val are unique.p != q
 Follow up: Can you find the LCA traversing the tree, without checking nodes existence?
*/
import java.util.*;
public class Lowest_Common_Ancestor_of_a_Binary_Tree_II__LC__1644 {
    public static void main(String arg[]){
        /*
        https://zhenchaogan.gitbook.io/leetcode-solution/leetcode-1644-lowest-common-ancestor-of-a-binary-tree-ii
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
    
    static class solution{
        boolean pExist;
        boolean qExist;
        public TreeNode lowestCommonAncestorII(TreeNode root,TreeNode p,TreeNode q){
            pExist=false;
            qExist=false;
            TreeNode lca = lowestCommonAncestor(root,p,q);
            return pExist&&qExist?root:null;
            
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root==null)
                return null;
            

            TreeNode leftAns = lowestCommonAncestor(root.left,p,q);  //search for p or q in left subtree
            TreeNode rightAns = lowestCommonAncestor(root.right,p,q);  //search for p or q in right subtree
            
            if(root==p){
                pExist=true;
                return root; //return the node whose value matched with p and meake pExist var true;
            }
            if(root==q){
                qExist=true;
                return root; //return the node whose value matched with q and meake qExist var true;
            }
                
            
            
            if(leftAns!=null && rightAns!=null)
                return root;  //it means we find the both p and q and this is the lca
            if(leftAns!=null)
                return leftAns;  //it mean we find p or q in left subtree so we return that node
            return rightAns;   //it mean we find p or q in right subtree so we return that node


        }
    }
    
}

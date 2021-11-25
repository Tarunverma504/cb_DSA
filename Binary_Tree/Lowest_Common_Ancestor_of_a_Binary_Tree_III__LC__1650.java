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
Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
Each node will have a reference to its parent node. The definition for Node is below:
class Node {    public int val;    public Node left;    public Node right;    public Node parent;}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1Output: 3Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4Output: 5Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [1,2], p = 1, q = 2Output: 1
Constraints:
The number of nodes in the tree is in the range [2, 105].-10^9 <= Node.val <= 10^9All Node.val are unique.p != qp and q exist in the tree.
*/
import java.util.*;
public class Lowest_Common_Ancestor_of_a_Binary_Tree_III__LC__1650 {
    public static void main(String arg[]){
        /*
          https://zhenchaogan.gitbook.io/leetcode-solution/leetcode-1650-lowest-common-ancestor-of-a-binary-tree-iii
        */
    } 
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    //inthis question we given the p and q node only and here in node class we have one more feild parent whih stor the address of the parent node 
    // so in thi firstly we have to find the root node the after that this question in same as lca (lowest common ancestor)
    
    class Solution{
        public Node lowestCommonAncestor(Node p,Node q){
            Node temp=p;
            Node root=getRoot(temp);
            return  lowestCommonAncestor1(root,p,q);
        }
        
        public Node getRoot(Node temp){
            while(temp!=null){
                temp=temp.parent;
            }
            return temp;
        }
        public Node lowestCommonAncestor1(Node root, Node p, Node q) {

            if(root==null)
                return null;
            if(root==p || root==q)
                return root; //return the node whose value matched with p or q

            Node leftAns = lowestCommonAncestor1(root.left,p,q);  //search for p or q in left subtree
            Node rightAns = lowestCommonAncestor1(root.right,p,q);  //search for p or q in right subtree
            if(leftAns!=null && rightAns!=null)
                return root;  //it means we find the both p and q and this is the lca
            if(leftAns!=null)
                return leftAns;  //it mean we find p or q in left subtree so we return that node
            return rightAns;   //it mean we find p or q in right subtree so we return that node


        }
    }
  
}

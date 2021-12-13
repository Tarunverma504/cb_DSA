/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Mind_Coder
 */
/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given InOrder Traversal.
3. you will be given an array representing a valid InOrder of a Binary Search Tree. Program is required to create a unique Balanced Binary Search Tree.
Input Format
Input is managed for you.
Output Format
output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder traversal.
Sample Input
7
1 2 3 4 5 6 7
Sample Output
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .


*/
import java.util.*;
public class Construct_Bst_From_Inorder_Traversal__PEP {
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-inorder-traversal/ojquestion#!
        */
    }
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return getTree(inOrder,0,inOrder.length-1);
    }
    public static TreeNode getTree(int[] in, int l,int r){
        if(l>r)
            return null;
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(in[mid]);
        root.left = getTree(in,l,mid-1);
        root.right = getTree(in,mid+1,r);
        return root;
    }
}

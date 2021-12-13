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
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PreOrder traversal.
Sample Input
6
3 2 1 6 5 7
Sample Output
2 -> 3 <- 6
1 -> 2 <- .
. -> 1 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .


*/
import java.util.*;
public class Construct_BstF_rom_Preorder_Traversal__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-preorder-traversal/ojquestion
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
    
    static int idx;
    public static TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        return getTree(preorder,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static TreeNode getTree(int[] pre, int minR, int maxR){
        
        if(idx>=pre.length || pre[idx]<minR || pre[idx]>maxR)
            return null;
        TreeNode root = new TreeNode(pre[idx++]);
        root.left = getTree(pre, minR, root.val);
        root.right = getTree(pre, root.val, maxR);
        return root;
    }
}

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
2. Task : Construct Binary Search Tree from given PostOrder Traversal.
3. you will be given an array representing a valid PostOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PostOrder traversal.
Sample Input
6
1 2 6 7 5 3
Sample Output
2 -> 3 <- 5
1 -> 2 <- .
. -> 1 <- .
. -> 5 <- 7
6 -> 7 <- .
. -> 6 <- .
*/
import java.util.*;
public class Construct_Bst_From_Postorder_Traversal__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-postorder-traversal/ojquestion
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
    
    static int index;
    public static TreeNode bstFromPostorder(int[] post) {
        
        index=post.length-1;
        return getTree(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static TreeNode getTree(int[] post, int minR, int maxR){
        if(index<0 || post[index]<minR || post[index]>maxR)
            return null;
        TreeNode root = new TreeNode(post[index--]);
        root.right = getTree(post, root.val, maxR);
        root.left = getTree(post, minR, root.val);
        return root;
        
    }

}

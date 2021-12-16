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
1. Given a Binary Tree, return Width Of Shadow Of A Binary Tree. 
2. For more detail watch the video.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
3


*/
import java.util.*;
public class Width_Of_Shadow_Of_Binary_Tree__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/width-of-a-binary-tree/ojquestion
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

     public static int width(TreeNode root) {
       int arr[] = new int[2];
       width(root, 0, arr);
       return arr[1]-arr[0]+1;
    }
    
    public static void width(TreeNode root, int lh, int[] arr){
        if(root==null)
            return;
        arr[0]=Math.min(arr[0],lh);
        arr[1]=Math.max(arr[1], lh);
        width(root.left,lh-1, arr);
        width(root.right,lh+1, arr);
    }
}

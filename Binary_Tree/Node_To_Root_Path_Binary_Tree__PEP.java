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
1. Given a Binary Tree, return root To Node path of it. 
2. For more Information watch given video link below.
Input Format
Input is managed for you.
Output Format
Input is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
4
2
1
-1
-1
3
-1
-1
6
5
-1
-1
7
-1
-1
5
Sample Output
5 6 4 


*/
import java.util.*;
public class Node_To_Root_Path_Binary_Tree__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/node-to-root-path-binary-tree/ojquestion
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

  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    // write your code here
    
    ArrayList<TreeNode> res = sol(node,data);
    return res==null?new ArrayList<>():res;
    
  }
  
  public static ArrayList<TreeNode> sol(TreeNode root, int data){
      if(root==null)
        return null;
      if(root.val==data){
        ArrayList<TreeNode> base = new ArrayList<>();
        base.add(root);
        return base;
      }
      
      ArrayList<TreeNode> left = sol(root.left, data);
      if(left!=null){
          left.add(root);
          return left;
      }
      
      ArrayList<TreeNode> right = sol(root.right, data);
      if(right!=null){
          right.add(root);
          return right;
      }
      return null;
  }
}

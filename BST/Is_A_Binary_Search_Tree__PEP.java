/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Tree.BST;

/**
 *
 * @author Mind_Coder
 */

/*
1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.
Input Format
Input is managed for you.
Output Format
true if the tree is a BST, false otherwise
Question Video

  COMMENTConstraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
Sample Output
true
*/
import java.util.*;
public class Is_A_Binary_Search_Tree__PEP {
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/online-java-foundation/binary-tree/is-bst-official/ojquestion
        */
    }
    public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
    public static class BSTPair{
      boolean isbst;
      int min;
      int max;
  }
  
  public static BSTPair isBST(Node root){
      
      if(root==null){
          BSTPair base = new BSTPair();
          base.isbst = true;
          base.min = Integer.MAX_VALUE;
          base.max = Integer.MIN_VALUE;
          return base;
      }
      
      BSTPair lp = isBST(root.left);
      BSTPair rp = isBST(root.right);
      BSTPair temp = new BSTPair();
      temp.isbst = lp.isbst && rp.isbst && (root.data>=lp.max && root.data<=rp.min);
      temp.min = Math.min(root.data, Math.min(lp.min, rp.min));
      temp.max = Math.max(root.data, Math.max(lp.max, rp.max));
      return temp;
  }
}

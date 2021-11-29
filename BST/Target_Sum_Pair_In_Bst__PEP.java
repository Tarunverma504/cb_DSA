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
1. You are given a partially written BST class.
2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
3. Input and Output is managed for you. 
Input Format
Input is managed for you
Output Format
"smaller node" "larger node"
.. all pairs that add to target on separate lines
Question Video

  COMMENTConstraints
None
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100
Sample Output
25 75
30 70
*/
import java.util.*;
public class Target_Sum_Pair_In_Bst__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/tsp-bst-official/ojquestion
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
    public static void targetSum( Node root,Node node, int data){
      if(node==null)
        return;
       targetSum(root, node.left,data);
        
      int comp = data-node.data;
      if(node.data<comp){
          if(find(root,comp))
            System.out.println(node.data+" "+comp);
      }
      targetSum(root,node.right, data);
  }
  
  public static boolean find(Node root, int data){
      if(root==null)
        return false;
      if(root.data>data)
        return find(root.left, data);
      else if(root.data<data){
          return find(root.right,data);
      }
      else{
          return true;
      }
    //   return false;
  }
}

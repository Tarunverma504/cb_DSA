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
2. You are required to complete the body of lca function. "lca" function is expected to find the lowest commong ancestor of d1 and d2.
3. Input and Output is managed for you. 

Note -> Please watch the question video for clarity.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
None
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
12
30
Sample Output
25
*/
import java.util.*;
public class Lca_Of_Bst__PEP {
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/lca-bst-official/ojquestion
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
    
    public static int lca(Node node, int p, int q) {
        // write your code here

        Node ans = getLcaNode(node,p,q);
        return ans.data;
      }

      public static Node getLcaNode(Node node,int p,int q){
          if(node==null)
            return null;
           if(node.data==p || node.data==q)
            return node;

            Node leftAns = getLcaNode(node.left,p,q);
            Node rightAns = getLcaNode(node.right,p,q);
            if(leftAns != null && rightAns!=null)
                return node;
            if(leftAns != null)
                return leftAns;
            return rightAns;
      }
}

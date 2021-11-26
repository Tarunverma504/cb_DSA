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
1. You are given a partially written BST class.
2. You are required to complete the body of add function. "add" function is expected to add a new node with given data to the tree and return the new root.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
None
Sample Input
23
50 25 12 n n 37 30 n n 40 n n 75 62 60 n n 70 n n 87 n n
61
Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
30 <- 37 -> 40
. <- 30 -> .
. <- 40 -> .
62 <- 75 -> 87
60 <- 62 -> 70
. <- 60 -> 61
. <- 61 -> .
. <- 70 -> .
. <- 87 -> .

*/
public class Add_Node_To_Bst__PEP {
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
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/add-node-to-bst-official/ojquestion
        */
    }
    public static Node add(Node node, int data) {
    // write your code here
    if(node==null){
        Node nn = new Node(data,null,null);
        return nn;
    }
    
    if(node.data>data){
        node.left=add(node.left,data);
    }
    if(node.data<data)
        node.right=add(node.right,data);
    return node;
    
    
  }
}

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
public class Size__Sum__Max__Min__Find_In_Bst__PEP {
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
    
    public static int size(Node node) {
    // write your code here
    if(node==null)
        return 0;
    int left = size(node.left);
    int right = size(node.right);
    return left+right+1;
  }

  public static int sum(Node node) {
    // write your code here
    
    if(node == null){
        return 0;
    }
    
    int left = sum(node.left);
    int right = sum(node.right);
    return left+right+node.data;
  }

  public static int max(Node node) {
    // write your code here
    if(node.right == null)
        return node.data;
    return max(node.right);
  }

  public static int min(Node node) {
    // write your code here
    
    if(node.left==null)
        return node.data;
    return min(node.left);
  }

  public static boolean find(Node node, int data){
    // write your code here
    if(node ==null)
        return false;
    if(node.data==data)
        return true;
    if(node.data>data){
        return find(node.left,data);
    }
    if(node.data<data){
        return find(node.right,data);
    }
    return false;
  }  

}

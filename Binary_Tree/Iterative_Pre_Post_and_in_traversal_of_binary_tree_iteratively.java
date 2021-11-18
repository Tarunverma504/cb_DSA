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
import java.util.*;
public class Iterative_Pre_Post_and_in_traversal_of_binary_tree_iteratively {
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
    static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }

    }


    public static void iterativePrePostInTraversal(Node root) {
      // write your code here
      Stack<Pair> st = new Stack<Pair>();
      Pair temp=new Pair(root,1);
      st.push(temp);
      String in="";
      String post="";
      String pre="";
      while(!st.isEmpty()){
          Pair top= st.peek();
          if(top.state==1){
              pre+=top.node.data+" ";
              top.state++;
              if(top.node.left!=null){
                  Pair p = new Pair(top.node.left,1);
                  st.push(p);
              }
          }
          else if(top.state==2){
              in+=top.node.data+" ";
              top.state++;
              if(top.node.right!=null){
                  Pair p = new Pair(top.node.right,1);
                  st.push(p);
              }
          }
          else{
              post+= top.node.data+" ";
              st.pop();
          }
      }
      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);

    }
}

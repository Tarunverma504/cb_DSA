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
public class Left_View_of_Binary_Tree__GFG {
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
        */
    }
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    class Tree
    {
        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> leftView(Node root)
        {
          // Your code here
          ArrayList<Integer> ans = new ArrayList<Integer>();
          if(root==null)
            return ans;
          Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            while(!q.isEmpty()){
                int n=q.size();
                for(int i=0;i<n;i++){
                    root=q.poll();
                    if(i==0)
                        ans.add(root.data);
                    if(root.left!=null)
                        q.add(root.left);
                    if(root.right!=null)
                        q.add(root.right);
                }
            }
            return ans;

        }
    }
}

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

import java.util.*;
public class search_node_in_bst {
    static Node root;
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.left=null;
            this.val=val;
            this.right=null;
        }
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int arr[]={10,30,35,40,50};
        int searchElement=40;
        construct(arr);
        display(root);
        System.out.println("Element Found :- "+search(root,40));
        
    }
    
    public  static boolean search(Node root,int k){
        if(root==null)
            return false;
        
        if(k>root.val)
            return search(root.right,k);
        else if(k<root.val)
            return search(root.left,k);
        else
            return true;
        
        
    }
    public static void construct(int[] arr){
        root=construct(arr,0, arr.length-1);
    }
    
    public static Node construct(int[] arr,int l, int r){
        if(l>r)
            return null;
        int mid=(l+r)/2;
        Node nn=new Node(arr[mid]);
        nn.left=construct(arr,l,mid-1);
        nn.right=construct(arr,mid+1,r);
        return nn;
    }
    
     public static void display(Node root){
        if(root == null)
            return;
        String str="";
        if(root.left!=null)
            str+=root.left.val;
        else
            str+='_';
        str+=""+ " ->" + root.val+ "<- ";
        if(root.right!=null)
            str+=root.right.val;
        else
            str+="_";
        System.out.println(str);
        display(root.left);
        display(root.right);
        
    }
    
    
}

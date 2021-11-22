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
public class construct_BST_from_sorted_array {
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
        int arr[]={10,30,35,40,50};
        construct(arr);
        display(root);
        System.out.println("Maximum Element:- "+max(root));
        System.out.println("Minimum Element:- "+min(root));
    }
    
    public static void construct(int[] arr){
        root=construct(arr,0, arr.length-1);
    }
    
    public static Node construct(int[] arr,int l,int r){
        if(l>r)
            return null;
        int mid=(l+r)/2;
        Node nn = new Node(arr[mid]);
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
    
    public static int max(Node root){
        if(root.right==null)
            return root.val;
        return max(root.right);
    }
    public static int min(Node root){
        if(root.left==null)
            return root.val;
        return min(root.left);
    }
}

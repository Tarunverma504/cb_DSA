/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Mind_Coder
 */

import java.util.*;
public class Trie_Contruct {
    
    static class Node{
        char val;
        Map<Character, Node> children;
        boolean isMarked;
        public  Node(char val){
            this.val = val;
            children = new HashMap<>();
            this.isMarked = false;
        }
    }
    static Node root;
    
    public static void insert(String word){
        Node current = root;
        for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
            if(current.children.containsKey(cc)){
                current = current.children.get(cc);
                
            }
            else{
                Node nn = new Node(cc);
                current.children.put(cc, nn);
                current = nn;
            }
            
        }
        
        current.isMarked = true;
    }
    
    public static boolean search(String word){
        Node current = root;
        for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
            if(current.children.containsKey(cc)){
                current = current.children.get(cc);
            }
            else{
               return false;
            }
            
        }
        return current.isMarked;
    }
    public static void main(String arg[]){
        root = new Node('*');
        insert("Karan");
        insert("Karn");
        System.out.println(search("Kara"));
    }
    
    
    
}

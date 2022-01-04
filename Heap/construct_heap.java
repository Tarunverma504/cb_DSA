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
public class construct_heap {
    
    static List<Integer> nodes;
    
    public static void add(int val){
        //1. insert at the lat of the node list
        nodes.add(val);
        //2. upheapify  
        int ci = nodes.size()-1;
        int parentI = ci/2;
        //nodes[pi]> nodes[ci] swap
        while(ci>1 && nodes.get(parentI)>nodes.get(ci)){
            int temp = nodes.get(parentI);
            nodes.set(parentI, nodes.get(ci));
            nodes.set(ci, temp);
            ci = parentI;
            parentI = parentI/2;
            
        }
    }
    
    public static void remove(){ //log n
        // 1. swap last and 1st index val
        
        int temp = nodes.get(1);
        nodes.set(1, nodes.get(nodes.size()-1));
        nodes.set(nodes.size()-1, temp);
        
        //2 remove the last node
        nodes.remove(nodes.size()-1);
        
        //3. down heapify
        downHeapify(1);
    }
    public static void downHeapify(int ci){
        
        int minI = ci;
        int lc = 2 * ci;
        int rc = 2 * ci +1;
        
        //comparison step to find minimum
        if(lc<nodes.size() && nodes.get(minI) > nodes.get(lc)){
            minI = lc;
        }
        if(rc < nodes.size() && nodes.get(minI) > nodes.get(rc)){
            minI = rc;
        }
        
        // swap minI and ci
        if(minI != ci){
            int temp = nodes.get(ci);
            nodes.set(ci, nodes.get(minI));
            nodes.set(minI, temp);
            
            //recall
            downHeapify(minI);
        }
    }
    
    public static int get(){
        return nodes.get(1);
    }
    
    public static boolean isEmpty(){
        return nodes.size()==1;
    }
    
    public static void main(String arg[]){
        nodes = new ArrayList<>();
        nodes.add(Integer.MIN_VALUE);
        add(10);
	add(20);
	add(30);
	add(5);
	add(3);
	System.out.println(nodes);
        remove();
	remove();
        System.out.println(nodes);
    }
}

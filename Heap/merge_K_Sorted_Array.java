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
public class merge_K_Sorted_Array {
    
    static class Node{
        int r, c, val;
        public Node(int r, int c,int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
        
        @Override
        public  String toString(){
            return val+" ";
        }
    }
    public static void main(String arg[]){
        int[][] arr = {{1, 10, 11, 15}, {2, 4, 9}, {5, 6, 8, 16}, {3, 7, 12, 13}};
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.val - o2.val;
            }
        });
        // add first column
        for(int r=0;r<arr.length;r++){
            pq.add(new Node(r, 0, arr[r][0]));
        }
        
        System.out.println(pq);
        
        while(!pq.isEmpty()){
            Node top = pq.remove();
            int r = top.r;
            int c = top.c;
            int val = top.val;
            System.out.print(val+" ");
            if(c+1<arr[r].length){
                pq.add(new Node(r, c+1, arr[r][c+1]));
            }
            
        }
        System.out.print(pq);
    }
}

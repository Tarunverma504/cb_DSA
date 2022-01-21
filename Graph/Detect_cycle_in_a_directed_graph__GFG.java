/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Mind_Coder
 */
/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
*/
import java.util.*;
public class Detect_cycle_in_a_directed_graph__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/#
        */
    }
    static class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // code hereint 

            int indegree[] = indegree(V, adj);
            return isCycle(indegree, V, adj);
        }

        public static boolean isCycle(int[] indegree, int v, ArrayList<ArrayList<Integer>> adj){
            int count=0;
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<v;i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int front = q.poll();
                count++;
                ArrayList<Integer> neighbours = adj.get(front);
                for(int neighbour:neighbours){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }
            return count!=v;
        }

        public static int[] indegree(int v, ArrayList<ArrayList<Integer>> adj){
            int indegree[] = new int[v];
            for(int i=0;i<v;i++){
                ArrayList<Integer> neighbours = adj.get(i);
                for(int neighbour:neighbours){
                    indegree[neighbour]++;
                }
            }
            return indegree;
        }
    }
}

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
Description
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Example 1:

Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
Example 2:

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.
*/
import java.util.*;
public class Graph_Valid_Tree_LC__178 {
    
    public static void main(String arg[]){
        /*
            https://www.lintcode.com/problem/178/
        */
    }
    static public class Solution {
        static int v;
        static Map<Integer, List<Integer>> adjList;

        public static void addEdge(int u, int v){
            List<Integer> neighbourU = adjList.getOrDefault(u, new ArrayList<>());
            neighbourU.add(v);
            adjList.put(u, neighbourU);
            List<Integer> neighbourV = adjList.getOrDefault(v, new ArrayList<>());
            neighbourV.add(u);
            adjList.put(v, neighbourV);
        }

        public static boolean isTree(int src){
            int[] parent = new int[v];
            Set<Integer> vis = new HashSet<>();
            for(int i=0;i<v;i++)
            parent[i]=i;

            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(src);
            vis.add(src);
            while(!bfs.isEmpty()){
                int front = bfs.poll();
                List<Integer> neighbours = adjList.getOrDefault(front, new ArrayList<>());
                for(int neighbour: neighbours){
                    if(!vis.contains(neighbour)){
                        bfs.add(neighbour);
                        vis.add(neighbour);
                        parent[neighbour]=front;
                    }
                    else if(neighbour!=parent[front]){
                        return false;
                    }
                }
            }
            //yahan cycle ni hai
		//check kro conn hai bhi?,'
            return vis.size()==v;
        }
        public boolean validTree(int n, int[][] edges) {
            // write your code here
            v = n;
            adjList = new HashMap<>();
            for(int i=0;i<edges.length;i++){
                int u = edges[i][0];
                int v = edges[i][1];
                addEdge(u, v);
            }

            return isTree(0);
        }
    }
}

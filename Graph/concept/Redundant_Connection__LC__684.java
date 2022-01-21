package Graph.concept;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */
/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
Accepted
178.7K
Submissions
294.2K
*/
import java.util.*;
public class Redundant_Connection__LC__684 {
    
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/redundant-connection/
        */
        
        /*
        hint use detectcycle DSU 
        */
    }
    static class Solution {
        static class Graph{
           static int v;
           static int[] parent;
           public Graph(int v){
               parent = new int[v];
               Arrays.fill(parent, -1);

           }

           public static int find(int u){
               if(parent[u] == -1)
                   return u;
               return find(parent[u]);
           }
            public static void union(int u, int v){
                int godFatherU = find(u);
                int godFatherV = find(v);
                if (godFatherU != godFatherV) {
                                   parent[godFatherU] = godFatherV;
                           }

            }

           public static int[] detectCycle(int[][] edges){
                for(int i=0;i<edges.length;i++){
                    int u = edges[i][0];
                    int v = edges[i][1];

                    int godFatherU = find(u);
                    int godFatherV = find(v);
                    if(godFatherU != godFatherV){
                        union(godFatherU, godFatherV);
                    }
                    else{
                        return new int[] {u,v};
                    }
                }
               return null;
            }

       }
       public int[] findRedundantConnection(int[][] edges) {
           Graph g = new Graph(edges.length+1);
           return g.detectCycle(edges);
       }
   }
}

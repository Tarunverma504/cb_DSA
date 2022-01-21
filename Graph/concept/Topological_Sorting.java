/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.concept;

/**
 *
 * @author Mind_Coder
 */

import java.util.*;
public class Topological_Sorting {
    public static class graph{
        // vertex vs list of neighbours
        int v;
        Map<Integer, List<Integer>> adjList;
        public graph(int v){
            this.v=v;
            this.adjList = new HashMap<>();
        }
        // u and v mein edge banaega
            // isBidir = true, u -> v, v -> u | false, u -> v
        public void addEdge(int u, int v, boolean isBidir){
            // TODO Auto-generated method stub

            // u = 1, v = 2
            // 1 -> 2
            List<Integer> neighbourU = adjList.getOrDefault(u, new ArrayList<>());
            neighbourU.add(v);
            adjList.put(u, neighbourU);
            if (isBidir) {
                // v -> u   
                // 2 -> 1
                List<Integer> neighbourV = adjList.getOrDefault(v, new ArrayList<>());
                neighbourV.add(u);
                adjList.put(v, neighbourV);
            }
        }
        private void display() {
                    // TODO Auto-generated method stub
                    //number of keys/vertices
                    //int numVertices = adjList.size();

                    for(int vertex : adjList.keySet()) {
                            //vertex -> []
                            System.out.println(vertex + "->" + adjList.get(vertex));
                    }
        }
        
        private int[] indegree(){
            int[] indegree = new int[v];
            for(int i=0;i<v;i++){
                List<Integer> neighbours = adjList.getOrDefault(i, new ArrayList<>());
                for(int neighbour:neighbours){
                    indegree[neighbour]++;
                }
            }
            return indegree;
        }
        
        private void topologicalSorting(){
            int[] indegree=indegree();
            Queue<Integer> bfs = new LinkedList<>();
            for(int i=0;i<v;i++){
                if(indegree[i]==0){
                    bfs.add(i);
                }
            }
            
            while(!bfs.isEmpty()){
                int front = bfs.poll();
                System.out.print(front+" ");
                List<Integer> neighbours = adjList.getOrDefault(front, new ArrayList<>());
                
                for(int neighbour:neighbours){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        bfs.add(neighbour);
                    }
                }
            }
        }
    }
    
    
    public static void main(String arg[]){
        graph g = new graph(8);
        g.addEdge(0, 1, false);
	g.addEdge(0, 2, false);
	g.addEdge(2, 3, false);
	g.addEdge(2, 4, false);
	g.addEdge(3, 1, false);
	g.addEdge(5, 3, false);
	g.addEdge(5, 6, false);
	g.addEdge(4, 6, false);
	g.addEdge(6, 7, false);
	g.addEdge(7, 4, false);
        g.topologicalSorting();
    }
}

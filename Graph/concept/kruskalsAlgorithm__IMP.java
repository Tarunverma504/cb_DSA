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
public class kruskalsAlgorithm__IMP {
    
    public static class EdgeList{
        int numV;
        List<Edge> edgeList;
        
        public static class Edge{
            int u;
            int v;
            int weight;
            public Edge(int u, int v,int wt){
                this.u = u;
                this.v = v;
                this.weight = wt;
            }

            @Override
            public String toString(){
                return "[" + u + "," + v + "," + weight + "]";
            }
        }
        
        public EdgeList(int numV){
            this.numV= numV;
            this.edgeList = new ArrayList<>();
        }
        
        private void addEdge(int u,int v,int wt){
            edgeList.add(new Edge(u, v, wt));
        }
        
    }
    
    private static int find(int u, int[] parent){
        if(parent[u]==-1)
            return u;
        return parent[u] = find(parent[u], parent);
    }
    
    private static void unionBySetSize(int u, int v, int[]parent, int[] rank){
        int godFatherU = find(u,parent);
        int godFatherV = find(v,parent);
        if(godFatherU != godFatherV){
            if (rank[godFatherU] < rank[godFatherV]){
                //v will be the parent of u
                parent[godFatherU] = godFatherV;
                 // (u + v) -> v, to v set ki rank update
                    rank[godFatherV]+=rank[godFatherU];
            }
            else{
                // u will be parent of v
                parent[godFatherV] = godFatherU;
                // (u + v) -> u, to u set ki rank update
                rank[godFatherU] += rank[godFatherV];
            }
        }
    }
    
    private static int kruskals_algo(List<EdgeList.Edge> edgeList, int[] parent, int[] rank){
        //Step - 1 -> sort the edges on the basis of weight
        Collections.sort(edgeList, new Comparator<EdgeList.Edge>(){
            public int compare(EdgeList.Edge o1, EdgeList.Edge o2) {//o1 -> curr, o2 -> curr + 1
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
        });
        //step - 2 iterate over edgelist
	int cost = 0;
        for(EdgeList.Edge currEdge: edgeList){
            int u = currEdge.u;
            int v = currEdge.v;
            int wt = currEdge.weight;
            int godFatherU = find(u, parent);
	    int godFatherV = find(v, parent);
            if(godFatherU != godFatherV) {
		unionBySetSize(godFatherU, godFatherV, parent, rank);
		cost += wt;
	    }
            
        }
        return cost;
    }
    
    public static void main(String arg[]){
        EdgeList graph = new EdgeList(5);
        graph.addEdge(0, 3, 2);
	graph.addEdge(0, 4, 12);
	graph.addEdge(3, 2, 2);
	graph.addEdge(4, 2, 7);
	graph.addEdge(3, 1, 6);
	graph.addEdge(1, 2, 1);
        
        int[] parent = new int[5];
        Arrays.fill(parent, -1);
        int[] rank = new int[5];
        Arrays.fill(rank, 1);
        System.out.println(graph.edgeList);
        System.out.println(kruskals_algo(graph.edgeList, parent, rank));
        System.out.println(graph.edgeList);
    }
}

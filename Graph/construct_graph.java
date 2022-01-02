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
import java.util.*;
public class construct_graph {
    
    
	// vertex vs list of neighbours
    int v;
    Map<Integer, List<Integer>> adjList;
    public construct_graph(int v){
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
    
    public void BFS(int src){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(src);
        vis.add(src);
        while(!q.isEmpty()){
            int front = q.poll();
            System.out.print(front+" ");
            List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());
            for(int x : neighbourList){
                if(!vis.contains(x)){
                    vis.add(x);
                    q.add(x);
                }
            }
            
        }
        
    }
    
    private void SSSP(int src){
        Map<Integer, Integer> dis = new HashMap<>();
        for(int i = 1; i <= v; i++) {
            dis.put(i, Integer.MAX_VALUE);
	}
		
	dis.put(src, 0);
        Queue<Integer> q = new LinkedList<>();
	q.add(src);
        while(!q.isEmpty()) {
            int front = q.poll();
            List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());
            for(int neighbour : neighbourList) {
		if(dis.get(neighbour) == Integer.MAX_VALUE) {
                    q.add(neighbour);
                    int frontKaDis = dis.get(front);
                    int neighbourKaDis = frontKaDis + 1;
                    dis.put(neighbour, neighbourKaDis);
                    System.out.println("Vertex " + neighbour + " is at a distance of " + neighbourKaDis + " from " + src);
		}
            }
        }
               
    }
    
    private void DFSHelper(int src){
        dfs(src, new HashSet<>());
        
    }
    
    private void dfs(int src, Set<Integer> vis){
        System.out.print(src+" ");
        vis.add(src);
        List<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());
        for(int neighbour:neighbours){
            if(!vis.contains(neighbour)){
                dfs(neighbour,vis);
            }
        }
    }
    private void BfsConn(int src, Set<Integer> vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis.add(src);
        while(!q.isEmpty()){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
            int front = q.poll();
            System.out.print(front+" ");
            List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());
            for(int neighbour: neighbourList){
                if(!vis.contains(neighbour)){
                    q.add(neighbour);
                    vis.add(neighbour);
                }
            }
        }
    }
    
    private void connectComponents(){
        Set<Integer> vis = new HashSet<>();
        int count=1;
        for(int i=1;i<=v;i++){
            if(!vis.contains(i)){
                System.out.print("CC "+count+" -> ");
                //dfs(i,vis);
                BfsConn(i, vis);
                count++;
                System.out.println();
            }
        }
        
    }
   public static void main(String arg[]){
       construct_graph g = new construct_graph(10);
//        g.addEdge(1, 2, true);// undirected(bidir) edge
//	g.addEdge(1, 3, true);
//	g.addEdge(2, 4, true);
//	g.addEdge(3, 4, true);
//	g.addEdge(3, 5, true);
//	g.addEdge(5, 6, true);
//	g.addEdge(6, 7, false);
//        //g.display();
//        g.BFS(2);
//        g.SSSP(4);
        
//        g.addEdge(1, 7, true);
//        g.addEdge(2, 3, true);
//	g.addEdge(2, 5, true);
//	g.addEdge(2, 7, true);
//	g.addEdge(5, 6, true);
//	g.addEdge(3, 4, true);
//	g.addEdge(4, 8, true);
//        g.DFSHelper(4);
        
       g.addEdge(1, 2, true);// undirected(bidir) edge
	g.addEdge(1, 3, true);
	g.addEdge(2, 4, true);
	g.addEdge(3, 4, true);
	g.addEdge(3, 5, true);
	g.addEdge(5, 6, true);
	g.addEdge(7, 8, true);
	g.addEdge(9, 10, true);
//        g.display();
        g.connectComponents();

   }
    
    
}

package Graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mind_Coder
 */
import java.util.*;
public class cycle_detect_DFS {
    static int v;
    static Map<Integer, List<Integer>> adjList;
    
    public static void addEdge(int u, int v,boolean isBidir){
        List<Integer> neighbourU = adjList.getOrDefault(u, new ArrayList<>());
        neighbourU.add(v);
        adjList.put(u, neighbourU);
        if(isBidir){
            List<Integer> neighbourV = adjList.getOrDefault(v, new ArrayList<>());
            neighbourV.add(u);
            adjList.put(v, neighbourV);
        }
    }
    public static void display(){
        for (int vertex : adjList.keySet()) {
	// vertex -> []
            System.out.println(vertex + "->" + adjList.get(vertex));
	}
    }
    public static boolean hasCycle(int src){
        Set<Integer> vis = new HashSet<>();
        return cycleDetectDfs(src, src, vis);
    }
    
    public static boolean cycleDetectDfs(int src, int parent, Set<Integer> vis){
        vis.add(src);
        boolean hasCycle=false;
        for(int neighbour:adjList.getOrDefault(src, new ArrayList<>())){
            if(!vis.contains(neighbour)){
                hasCycle = cycleDetectDfs(neighbour, src, vis);
                if(hasCycle)
                    return hasCycle;
            }
            else if(neighbour!=parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String arg[]){
        
        v=5;
        adjList = new HashMap<>();
        addEdge(0,1, true);
        addEdge(1,2, true);
        addEdge(2, 3, true);
        addEdge(2, 4, true);
        display();
        System.out.println(hasCycle(0));
    }
}

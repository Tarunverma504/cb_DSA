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
public class Bellman_Ford_ALGO {
    
    static int numV;
    static List<Edge>  edgeList;
    
    static class Edge{
        int u, v, wt;
        public  Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    
    public static void addEdge(int u, int v, int wt){
        edgeList.add(new Edge(u, v, wt));
    }
    
    public static void sol(int src){
        int[] dis = new int[numV];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for(int iter =1; iter<=numV-1; iter++){
            for(Edge edge:edgeList){
                //u se start or v pe end
                if(dis[edge.u]!=Integer.MAX_VALUE && dis[edge.v]>dis[edge.u]+edge.wt){
                    dis[edge.v]=dis[edge.u]+edge.wt;
                }
            }
        }
        for(Edge edge:edgeList){
                //u se start or v pe end
            if(dis[edge.u]!=Integer.MAX_VALUE && dis[edge.v]>dis[edge.u]+edge.wt){
                System.out.println("Kyun negativity faila raha hai!");
		break;
            }
        }
        for (int i = 0; i < numV; i++) {
            System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
        }
    }
    
    public static void main(String arg[]){
        numV = 6;
        edgeList = new ArrayList<>();
        addEdge(0, 1, 10);
	addEdge(0, 2, 20);
	addEdge(1, 3, 20);
	addEdge(2, 4, 15);
	addEdge(1, 4, 15);
	addEdge(3, 5, 30);
	addEdge(4, 5, 10);
//	addEdge(4, 0, -30);
	sol(0);
        
    }
}

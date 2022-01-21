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
public class Dijkstra__Algo {
    
    public static void main(String arg[]){
        int[][] conn ={ { 0, 5, 10, 0, 0 }, { 5, 0, 3, 11, 0 }, { 10, 3, 0, 2, 0 }, { 0, 11, 2, 0, 3 },
				{ 0, 0, 0, 3, 0 } };
        for(int r=0;r<conn.length;r++){
            for(int c=0;c<conn[0].length;c++){
                if(conn[r][c]==0)
                    conn[r][c]=Integer.MAX_VALUE; //0 means there is not direct edge so we change 0 to infinity
                
            }
        }
        
        sol(conn,1);
    }
    
    public static void sol(int[][] graph, int src){
        boolean vis[] = new boolean[graph.length];
        int dis[] = new int[graph.length];// store shortest distance
        vis[src]=true;
        for(int i=0;i<graph.length;i++){
            dis[i] = graph[src][i];//dis[i] matlab hai src se i ka distance
        }
        dis[src]=0; // set distance of src 0
        System.out.println("Node chosen is "+ src);
        for(int i=1;i<graph.length;i++){
            int minDist = Integer.MAX_VALUE;
            int targetV = -1;
            for(int v=0;v<graph.length;v++){ //select unvisited vertex with smallest value
                if(!vis[v] && minDist>dis[v]){
                    targetV = v;
                    minDist = dis[v];
                }
            }
            System.out.println("Node  chosen is " + targetV);
            vis[targetV] = true;
            
             // Update all the neighbouring vertex distances
            for(int v=0;v<graph.length;v++){
                if(!vis[v] && graph[targetV][v]!=Integer.MAX_VALUE && dis[v]>  dis[targetV] + graph[targetV][v]){
                    dis[v] = dis[targetV] + graph[targetV][v];
                }
            }
        }
        for(int i = 0; i < graph.length; i++) {
            System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
	}
        
    }
}

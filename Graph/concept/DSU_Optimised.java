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
public class DSU_Optimised {
    int v;
    private int[] parent;
    
    public DSU_Optimised(int v){
        parent = new int[v];
        Arrays.fill(parent, -1);
        
    }
    private int find(int u){
        if(parent[u]==-1)
            return u;
        return parent[u] = find(parent[u]);
    }
    
    private void union(int u, int v) {// O(n)
		// TODO Auto-generated method stub

		// step - 1 gf(u), gf(v)
		// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
		int godFatherU = find(u);
		int godFatherV = find(v);

		if (godFatherU != godFatherV) {
			parent[godFatherU] = godFatherV;
		}
	}
    private boolean detectCyce(int[][] edgeList){
        
        for(int r=0;r<edgeList.length;r++){
            int u = edgeList[r][0];
            int v = edgeList[r][1];
            
            int godFatherU = find(u);
            int godFatherV = find(v);
            
            //step - 2 gf(u) != gf(v) -> union
	     //step - 3 gf(u) == gf(v) -> return cycle hai
	    if(godFatherU != godFatherV) {
		union(godFatherU, godFatherV);
	    } else {
		return true;
	    }
        }
        return false;
        
    }
    
    public static void main(String arg[]){
        int numV = 7;
        int[][] edgeList = { { 0, 1 }, { 1, 2 }, { 2, 3 }, {4, 5}, {5, 6} };
        DSU_Optimised dsu = new DSU_Optimised(numV);
        System.out.println(dsu.detectCyce(edgeList));
    }
}

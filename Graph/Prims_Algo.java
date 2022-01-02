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
public class Prims_Algo {
    
    public static void main(String arg[]){
        int[][] conn = { { 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 } // 8
		};
        for(int r=0;r<conn.length;r++){
            for(int c=0;c<conn[0].length;c++){
                if(conn[r][c]==0)
                    conn[r][c]=Integer.MAX_VALUE;
            }
        }
        
        primsMST(conn);
    }
    
    public static void primsMST(int[][] conn){
        boolean vis[] = new boolean[conn.length];
        vis[0]=true;
        int cost=0;
        for(int v=1; v<conn.length; v++){
            int s=0;
            int e=0;
            for(int i=0;i< conn.length;i++){
                if(vis[i]){
                    for(int j=0;j<conn.length;j++){
                        if(!vis[j] && conn[i][j]<conn[s][e]){
                            s=i;
                            e=j;
                        }
                    }
                }
            }
            System.out.println("Chosen edge is :"+s+" "+e);
            vis[e]=true;
            cost+=conn[s][e];
        }
        System.out.println(cost);
    }
}

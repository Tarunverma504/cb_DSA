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
/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
Accepted
91.6K
Submissions
163K
*/
import java.util.*;
public interface Most_Stones_Removed_with_Same_Row_or_Column__LC__947 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
        */
    }
    static class Solution {
        static class Graph{
            static int V;
            static int[] parent;
            public Graph(int v){
                this.V = v;
                this.parent = new int[v];
                Arrays.fill(parent, -1);
            }
            public static int find(int u){
                if(parent[u] == -1)
                    return u;
                return parent[u] = find(parent[u]);
            }
            public static int union(int u, int v){
                // step - 1 gf(u), gf(v)
		// step - 2 gf(u) != gf(v) -> p[gf(u)] = gf(v)
                int godFatherU = find(u);
                int godFatherV = find(v);
                // v ko u ka parent
                if(godFatherU != godFatherV){
                    parent[godFatherU] = godFatherV;
                    return 1;//1 union ho gya hai
                }
                return 0;//abhi union ni hua j, i mein
            }
        }





        public int removeStones(int[][] stones) {
            int numComp = stones.length;

            Graph g = new Graph(stones.length);
            for(int i=0;i<stones.length-1;i++){
                for(int j=i+1;j<stones.length;j++){
                    int[] v1 = stones[i]; // {0, 0}, r = 0, c = 0
                    int[] v2 = stones[j]; // {0, 2}, r = 0, c = 2
                    
                    // union krne ki 2 condns
		    // ya to row equal ya 
                    // gf(v1) != gf(v2)
                    if(v1[0]==v2[0] || v1[1]==v2[1]){
                        numComp = numComp - g.union(j, i);
                    }
                }
            }
            return stones.length - numComp;
        }
    }
}

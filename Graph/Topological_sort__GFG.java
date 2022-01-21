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
/*
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.


Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then console output will be 1 else 0.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2


*/
import java.util.*;
public class Topological_sort__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/topological-sort/1/#
        */
    }
    static class Solution
    {
        //Function to return list containing vertices in Topological order. 
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            // add your code here

            int indegree[] = indegree(V,adj);
            int ans[] = new int[V];
            int k=0;
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<V;i++){
                if(indegree[i]==0)
                    q.add(i);
            }
            while(!q.isEmpty()){
                int front = q.poll();
                ans[k++]=front;
                ArrayList<Integer> neighbours = adj.get(front);
                for(int neighbour: neighbours){
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0){
                        q.add(neighbour);
                    }
                }
            }
            return ans;
        }

        public static int[] indegree(int v, ArrayList<ArrayList<Integer>> adj){
            int indegree[] = new int[v];
            for(int i=0;i<v;i++){
                ArrayList<Integer> neighbours = adj.get(i);
                for(int neighbour:neighbours){
                    indegree[neighbour]++;
                }
            }
            return indegree;
        }
    }

}

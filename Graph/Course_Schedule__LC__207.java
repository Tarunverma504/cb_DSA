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
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
Accepted
748,208
Submissions
1,672,049
Seen this question in a real interview before?

Yes

No
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
*/
import java.util.*;
public class Course_Schedule__LC__207 {  
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/course-schedule/
        */
    }
    static class Solution {
        static int v;
        static Map<Integer, List<Integer>> adjList;
        public static void addEdge(int u, int v){
            List<Integer> neighbour = adjList.getOrDefault(u, new ArrayList<Integer>());
            neighbour.add(v);
            adjList.put(u, neighbour);
        }
        public static int[] indegree(){
            int[] indegree = new int[v];
            for(int i=0;i<v;i++){
                List<Integer> neighbours = adjList.getOrDefault(i, new ArrayList<>());
                for(int neighbour: neighbours){
                    indegree[neighbour]++;
                }
            }
            return indegree;
        }
        public static boolean detectCycle(){
            int[] indegree = indegree();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<v;i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }
            int count=0;
            while(!q.isEmpty()){
                int front = q.poll();
                List<Integer> neighbours = adjList.getOrDefault(front, new ArrayList<>());
                count++;
                for(int neighbour:neighbours){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }
            return count==v;
        }
        public boolean canFinish(int numCourses, int[][] pre) {
            v = numCourses;
            adjList = new HashMap<>();
            for(int i=0;i<pre.length;i++){
                addEdge(pre[i][1], pre[i][0]);
            }

            return detectCycle();
        }
    }
}

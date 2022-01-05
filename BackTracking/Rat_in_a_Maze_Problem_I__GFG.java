/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

/**
 *
 * @author Mind_Coder
 */
/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1
*/
import java.util.*;
public class Rat_in_a_Maze_Problem_I__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
        */
    }
    static class Solution {
        public static ArrayList<String> findPath(int[][] m, int n) {
            // Your code here
            ArrayList<String> ans = new ArrayList<>();
            if(m[0][0]==0)
                return ans;
            int[][] vis= new int[n][n];
            solve(0, 0, m, n, vis,"", ans);
            Collections.sort(ans);
            return ans;
        }

        public static void solve(int i, int j, int[][] arr, int n, int[][] vis, String move,ArrayList<String> ans ){
            if(i==n-1 && j==n-1){
                ans.add(move);
                return ;
            }

            //down
            if(i+1<n && vis[i+1][j]!=1 && arr[i+1][j]!=0){
                vis[i][j]=1;
                solve(i+1, j, arr, n, vis, move+"D", ans);
                vis[i][j]=0;//backtrack
            }
            // left
            if(j-1>=0 && vis[i][j-1]!=1 && arr[i][j-1]!=0){
                vis[i][j]=1;
                solve(i, j-1, arr, n, vis, move+"L", ans);
                vis[i][j]=0;//backtrack
            }
            //up
            if(i-1>=0 && vis[i-1][j]!=1 && arr[i-1][j]!=0){
                vis[i][j]=1;
                solve(i-1, j, arr, n, vis, move+"U", ans);
                vis[i][j]=0;//backtrack
            }
            //right
            if(j+1<n && vis[i][j+1]!=1 && arr[i][j+1]!=0){
                vis[i][j]=1;
                solve(i, j+1, arr, n, vis, move+"R", ans);
                vis[i][j]=0;//backtrack
            }

        }
    }
}

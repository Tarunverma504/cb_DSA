package DP;

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
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
Accepted
363.4K
Submissions
741.7K
*/
import java.util.*;
public class Triangle__LC__120 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/triangle/
        */
    }
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int cache[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
            for(int[] row : cache)
                Arrays.fill(row,-1);
            return getResult(triangle,0,0,cache);
        }

        public static int getResult(List<List<Integer>> triangle, int cr, int cc,int[][] cache){

            if(cr==triangle.size())
                return 0;
            if(cache[cr][cc]!=-1)
                return cache[cr][cc];
            int c1 = getResult(triangle,cr+1,cc,cache);
            int c2 = getResult(triangle,cr+1,cc+1,cache);
            cache[cr][cc] = Math.min(c1,c2)+triangle.get(cr).get(cc);
            return cache[cr][cc];

        }
    }
}

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
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
*/
import java.util.*;
public class Minimum_Falling_Path_Sum__LC__931 {
    
    public static void main(String arg[]){
        /*
        https://leetcode.com/problems/minimum-falling-path-sum/
        */
    }
    static class Solution {
        public int minFallingPathSum(int[][] matrix) {

            int min = Integer.MAX_VALUE;
            int cache[][] = new int[matrix.length+1][matrix[0].length+1];
            for(int[] row: cache)
                Arrays.fill(row,-1);
            for(int i=0;i<matrix[0].length;i++)
               min = Math.min(min,getResult(matrix,0,i,matrix.length,matrix[0].length,cache));
            return min;
        }

        public static int getResult(int[][] matrix, int cr,int cc,int er,int ec,int[][] cache){

            if(cr==er)
                return 0;
            if(cache[cr][cc]!=-1)
                return cache[cr][cc];
            if(cr == matrix.length-1)
                return matrix[cr][cc];
            int c1=Integer.MAX_VALUE;
            if(cr+1<er && cc-1>=0)
                c1 = getResult(matrix,cr+1,cc-1,er,ec,cache); 
            int c2 = Integer.MAX_VALUE;
            if(cr+1<er && cc<ec)
             c2 =  getResult(matrix,cr+1,cc,er,ec,cache); 
            int c3 = Integer.MAX_VALUE;
            if(cr+1<er && cc+1<ec)
             c3 = getResult(matrix,cr+1,cc+1,er,ec,cache);
            // System.out.println(c1+" "+c2+" "+c3);
            cache[cr][cc] = Math.min(c1,Math.min(c2,c3))+matrix[cr][cc];
            return cache[cr][cc];

        }
    }
}

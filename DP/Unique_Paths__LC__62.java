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
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
*/
import java.util.*;
public class Unique_Paths__LC__62 {
    static class Solution {
        public int uniquePaths(int m, int n) {

            int[][] cache = new int[m][n];
            for(int row[]:cache){
                Arrays.fill(row,-1);
            }
            return getPaths(m-1, n-1, cache);
        }

        public static int getPaths(int m, int n,int[][] cache){

            if(m==0 && n==0)
                return 1;
            if(m<0 || n<0)
                return 0;
            if(cache[m][n]!=-1)
                return cache[m][n];
            int c1 = getPaths(m-1,n,cache);
            int c2 = getPaths(m,n-1,cache);
            cache[m][n] = c1+c2;
            return cache[m][n];
        }
    }
}

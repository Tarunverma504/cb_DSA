/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Mind_Coder
 */
/*
Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. Print the answer modulo 109+7.

 

Example 1:

Input:
W = 3
Output:
3
Explanation:
We need 3 tiles to tile the board
of size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile vertically.
and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally
and remaining tiles vertically.
Example 2:

Input:
W = 4
Output:
5
Explanation:
For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining
2 horizontal.
4) First 2 horizontal, remaining
2 vertical.
5) Corner 2 vertical, middle
2 horizontal.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numberOfWays() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105

View Bookmarked Problems
*/
import java.util.*;
public class Ways_To_Tile_A_Floor__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1#
        */
    }
    static class Solution {
        static long mod = 1000000007;
        static Long numberOfWays(int N) {
            // code here
            long cache[] = new long[N+1];
            Arrays.fill(cache,-1);
            return numberOfWays(N,cache);

        }
        static Long numberOfWays(int N,long[] cache){
            if(N<0)
                return (long)0;
            if(N==0)
                return (long)1;
            if(cache[N]!=-1)
                return cache[N];
            //when we place vertically 
            long c1 = numberOfWays(N-1,cache);
            //when we place horizontally
            long c2 = numberOfWays(N-2,cache);
            cache[N]= (c1+c2)%mod;
            return cache[N];
        } 
    };
}

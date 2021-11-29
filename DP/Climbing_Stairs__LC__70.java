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
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
*/
import java.util.*;
public class Climbing_Stairs__LC__70 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/climbing-stairs/
        */
    }
    
    static class Solution {
        public int climbStairs(int n) {

            int cache[] = new int[n+1];
            Arrays.fill(cache,-1);
            return climbStairs(n,cache);
        }

        public static int climbStairs(int n,int[] cache){
            if(n==0)
                return 1;
            if(n<0)
                return 0;
            if(cache[n]!=-1){
                return cache[n];
            }

            int c1 = climbStairs(n-1,cache);
            int c2 = climbStairs(n-2,cache);
            cache[n]=c1+c2;
            return cache[n];
        }
    }
}

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
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/
import java.util.*;
public class Min_Cost_Climbing_Stairs__LC__746 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/min-cost-climbing-stairs/
        */
    }
    static class Solution {
        public int minCostClimbingStairs(int[] cost) {

            int cache[]=new int[cost.length+1];
            Arrays.fill(cache,-1);
            int case1 = getResult(cost,0,cache);
            int case2 = getResult(cost,1,cache);
            return Math.min(case1,case2);

        }

        public static int getResult(int[] cost, int curr,int[] cache){
            if(curr>=cost.length)
                return 0;
            if(curr==cost.length-1)
                return cost[curr];
            if(cache[curr]!=-1)
                return cache[curr];
            int c1 = getResult(cost,curr+1,cache);
            int c2 = getResult(cost,curr+2,cache);
            cache[curr] = Math.min(c1,c2)+cost[curr];
            return cache[curr];

        }
    }
}

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
import java.util.*;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
*/
public class Coin_Change_2__LC__518 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/coin-change-2/
        */
    }
    
    static class Solution {
        public int change(int amount, int[] coins) {

            int[][] cache = new int[amount+1][coins.length+1];
            for(int[] row:cache)
                Arrays.fill(row,-1);
            return change(amount,coins,coins.length,cache);
        }

        public static int change(int amount, int[] coins,int n, int[][] cache){
            if(amount==0)
                return 1;
            if(n==0)
                return 0;
            if(cache[amount][n]!=-1)
                return cache[amount][n];
            int pick=0;
            if(coins[n-1] <= amount){
                pick = change(amount-coins[n-1], coins,n,cache);
            }
            int dontpick=0;
            dontpick = change(amount, coins, n-1,cache);
            cache[amount][n] = pick + dontpick;
            return cache[amount][n];
        }

    }
}

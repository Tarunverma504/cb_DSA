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
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/
public class Best_Time_to_Buy_and_Sell_Stock_IV__LC__188 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        */
    }
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int dp[][][] = new int[prices.length][2][k+1];
            for(int i=0;i<prices.length;i++){
                for(int j=0;j<2;j++){
                    for(int z=0;z<k+1;z++){
                        dp[i][j][z]=-1;
                    }
                }
            }
            return sol(prices, 0, 1, 0, k ,dp);
        }

        public static int sol(int[] prices,int curr, int buy, int k,int count, int[][][] dp){

            if(k==count|| curr==prices.length) //almost 2 stocks
                return 0;
            if(dp[curr][buy][k]!=-1)
                return dp[curr][buy][k];
            if(buy == 1){
                int c1 = sol(prices, curr+1, 0, k,count, dp) - prices[curr];  //buy kia curr 
                int c2 = sol(prices, curr+1, buy, k,count, dp); // sayad agle din buy
                dp[curr][buy][k] = Math.max(c1,c2);
                return dp[curr][buy][k];
            }
            else{
                int c1 = sol(prices, curr+1, 1,k+1,count, dp) + prices[curr]; // sell kia curr
                int c2 = sol(prices, curr+1, buy, k,count, dp); //sayad agle din sell
                dp[curr][buy][k]  = Math.max(c1,c2);
                return dp[curr][buy][k];
            }
        }
    }
}

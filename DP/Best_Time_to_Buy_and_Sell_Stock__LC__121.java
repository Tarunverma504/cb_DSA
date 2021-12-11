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
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/
public class Best_Time_to_Buy_and_Sell_Stock__LC__121 {
 
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        */
    }
    static class Solution {
        public int maxProfit(int[] prices) {
            int dp[][] = new int[prices.length][2];
            for(int i=0;i<prices.length;i++){
                dp[i][0]=-1;
                dp[i][1]=-1;
            }
            return sol(prices, 0, 1, 1, dp);
        }

        public static int sol(int[] prices,int curr, int buy, int k, int[][] dp){

            if(k==0 || curr==prices.length)
                return 0;
            if(dp[curr][buy]!=-1)
                return dp[curr][buy];
            if(buy == 1){
                int c1 = sol(prices, curr+1, 0, k, dp) - prices[curr];  //buy kia curr 
                int c2 = sol(prices, curr+1, buy, k, dp); // sayad agle din buy
                dp[curr][buy] = Math.max(c1,c2);
                return dp[curr][buy];
            }
            else{
                int c1 = sol(prices, curr+1, buy,k-1, dp) + prices[curr]; // sell kia curr
                int c2 = sol(prices, curr+1, buy, k, dp); //sayad agle din sell
                dp[curr][buy]  = Math.max(c1,c2);
                return dp[curr][buy];
            }
        }
    }
}

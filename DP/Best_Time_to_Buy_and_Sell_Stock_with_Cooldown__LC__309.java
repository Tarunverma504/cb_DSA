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

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000
Accepted
241.9K
Submissions
474.2K
*/
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown__LC__309 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        */
    }
    static class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for(int i=0;i<prices.length;i++){
                dp[i][0]=-1;
                dp[i][1]=-1;
            }

            return sol(prices, 0, 1, dp);
        }

        public static int sol(int[] prices, int curr, int buy, int[][] dp){

            if(curr>=prices.length)
                return 0;
            if(dp[curr][buy]!=-1)
                return dp[curr][buy];
            if(buy==1){
                int c1 = sol(prices,curr+1,0,dp)-prices[curr];
                int c2 = sol(prices, curr+1, buy, dp);
                dp[curr][buy] = Math.max(c1,c2);
                return dp[curr][buy];
            }
            else{
                int c1 = sol(prices,curr+2,1,dp)+prices[curr];
                int c2 = sol(prices, curr+1, buy,dp);
                 dp[curr][buy] = Math.max(c1,c2);
                return dp[curr][buy];
            }
        }
    }
}

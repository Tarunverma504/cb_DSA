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
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
*/
public class Best_Time_to_Buy_and_Sell_Stock_II__LC__122 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        */
    }
    
    static class Solution {
        public int maxProfit(int[] prices) {
             int dp[][] = new int[prices.length][2];
            for(int i=0;i<prices.length;i++){
                dp[i][0]=-1;
                dp[i][1]=-1;
            }
            return sol(prices, 0, 1, dp);
        }
         public static int sol(int[] prices,int curr, int buy, int[][] dp){

            if(curr==prices.length)
                return 0;
            if(dp[curr][buy]!=-1)
                return dp[curr][buy];
            if(buy == 1){
                int c1 = sol(prices, curr+1, 0, dp) - prices[curr];  //buy kia curr 
                int c2 = sol(prices, curr+1, buy, dp); // sayad agle din buy
                dp[curr][buy] = Math.max(c1,c2);
                return dp[curr][buy];
            }
            else{
                int c1 = sol(prices, curr+1, 1, dp) + prices[curr]; // sell kia curr
                int c2 = sol(prices, curr+1, buy, dp); //sayad agle din sell
                dp[curr][buy]  = Math.max(c1,c2);
                return dp[curr][buy];
            }
        }
    }
}

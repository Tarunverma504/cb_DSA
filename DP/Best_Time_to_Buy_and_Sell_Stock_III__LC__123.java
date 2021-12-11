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
public class Best_Time_to_Buy_and_Sell_Stock_III__LC__123 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        */
    }
    static class Solution {
        public int maxProfit(int[] prices) {
            int dp[][][] = new int[prices.length][2][2];
            for(int i=0;i<prices.length;i++){
                dp[i][0][0]=-1;
                dp[i][0][1]=-1;
                dp[i][1][0]=-1;
                dp[i][1][1]=-1;
            }
            return sol(prices, 0, 1, 0 ,dp);
        }

        public static int sol(int[] prices,int curr, int buy, int k, int[][][] dp){

            if(k==2 || curr==prices.length) //almost 2 stocks
                return 0;
            if(dp[curr][buy][k]!=-1)
                return dp[curr][buy][k];
            if(buy == 1){
                int c1 = sol(prices, curr+1, 0, k, dp) - prices[curr];  //buy kia curr 
                int c2 = sol(prices, curr+1, buy, k, dp); // sayad agle din buy
                dp[curr][buy][k] = Math.max(c1,c2);
                return dp[curr][buy][k];
            }
            else{
                int c1 = sol(prices, curr+1, 1,k+1, dp) + prices[curr]; // sell kia curr
                int c2 = sol(prices, curr+1, buy, k, dp); //sayad agle din sell
                dp[curr][buy][k]  = Math.max(c1,c2);
                return dp[curr][buy][k];
            }
        }
    }
}

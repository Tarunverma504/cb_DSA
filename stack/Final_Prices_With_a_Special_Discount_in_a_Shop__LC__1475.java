package stack;

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
Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.

Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

 

Example 1:

Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation: 
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4. 
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2. 
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4. 
For items 3 and 4 you will not receive any discount at all.
Example 2:

Input: prices = [1,2,3,4,5]
Output: [1,2,3,4,5]
Explanation: In this case, for all items, you will not receive any discount at all.
Example 3:

Input: prices = [10,1,1,6]
Output: [9,0,1,6]
*/

import java.util.*;
public class Final_Prices_With_a_Special_Discount_in_a_Shop__LC__1475 {
    static class Solution {
        public static void main(String arg[]){
            /*
                https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
            */
        }
        public int[] finalPrices(int[] prices) {
            if(prices.length<=1)
                return prices;
            int arr[]=new int[prices.length];
            arr[arr.length-1]=-1;
            Stack<Integer> st = new Stack<Integer>();
            st.push(prices[prices.length-1]);
            for(int i= prices.length-2;i>=0;i--){
                while(!st.isEmpty() && st.peek()>prices[i])
                    st.pop();
                if(st.isEmpty()){
                    arr[i]=-1;
                }
                else
                    arr[i]=st.peek();
                st.push(prices[i]);
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==-1)
                    arr[i]=prices[i];
                else{
                    arr[i]=prices[i]-arr[i];
                }

            }
            return arr;
        }
    }
}

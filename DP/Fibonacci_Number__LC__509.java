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
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30
Accepted
557,996
Submissions
822,596
*/
import java.util.*;
public class Fibonacci_Number__LC__509 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/fibonacci-number/
        */
    }
    static class Solution {
        public int fib(int n) {
            int cache[] = new int[n+1];
            Arrays.fill(cache,-1);
            int ans = fib(n,cache);
            return ans;
        }
        public static int fib(int n,int[] cache){
            if(n==1 || n==0)
                return n;
            if(cache[n]!=-1)
                return cache[n];
            int fibN_1 = fib(n-1,cache);
            int fibN_2 = fib(n-2,cache);
            int  fibn = fibN_1 + fibN_2;
            cache[n] = fibn;
            return cache[n];
        }
    }
}

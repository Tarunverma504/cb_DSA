/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Mind_Coder
 */
/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Question Video

  COMMENTConstraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75
*/
import java.util.*;
public class Zero_One_Knapsack__CB {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value[] = new int[n];
        int weight[] = new int[n];
        for(int i=0;i<n;i++){
            value[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        
        int capacity = sc.nextInt();
        int[][] cache = new int[n + 1][capacity + 1];//curr(n) * capacity(cap)
        for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
        System.out.println(sol(value, weight, n, 0, capacity,cache));
        
    }
    
    public static int sol(int[] value, int[] weight,int n,int curr,int capacity, int[][] cache){
        
        if(capacity == 0 || curr==n)
            return 0;
        if(cache[curr][capacity] != -1) {
			return cache[curr][capacity];
		}
        int pick=0, dontpick=0;
        
        if(weight[curr] <= capacity){
            pick=sol(value, weight, n, curr+1, capacity-weight[curr],cache) + value[curr];
        }
        dontpick = sol(value, weight, n, curr+1,capacity,cache);
        return cache[curr][capacity] = Math.max(pick,dontpick);
    }
}

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
A railway track is made with the help of two horizontal rails and railway sleepers as seen in figure.

Drag Racing

There are two horizontal rails X and Y. On railway line X, N numbers are written and on railway line Y, M numbers are written

Paul works as an engineer in the railway department. Paul was tasked to join these two rails with sleepers to complete the railway track.

But there is a condition to join the rails with sleepers. The sleepers will be put on the position i and j such that -

The number written on X at ith position i.e X[i] should be equal to the number written on Y at jth position i.e Y[j].

The sleepers should not intersect or cross each other at all.

A sleeper X[i] can only be combined with a single Y[j].

Return the maximum number of sleepers that Paul has to connect to complete the railway track.

Input Format
First line contains two integers N and M i.e the count of numbers written on each rail X and Y. Second line contains N numbers that are written on rail X. Third line contains M numbers that are written on rail Y.

Constraints
1 <= N <= 500
1 <= M <= 500

Output Format
A single integer, the maximum number of sleepers that Paul has to connect to complete the railway track.

Sample Input
6 5
1 3 7 1 7 5
1 9 2 5 1
Sample Output
2
Explanation
We can combine X[0] and Y[0], then we can combine X[3] and Y[4].

However, if we will also try to connect X[5] and Y[3] the will intersect with the connection X[3] and Y[4], thus we can choose only one out of these two.

Thus the answer is 2.
*/
import java.util.*;
public class Paul_And_Railway_Track__CB {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int s[] = new int[n1];
        int t[] = new int[n2];
        for(int i=0;i<n1;i++)
            s[i]=sc.nextInt();
        for(int j=0;j<n2;j++)
            t[j]=sc.nextInt();
        int cache[][] = new int[n1+1][n2+1];
        for(int row[]: cache)
            Arrays.fill(row,-1);
        System.out.println(getResult(s, 0, t, 0, cache));
    }

    public static int getResult(int[] s, int cs, int[] t, int ct,int[][] cache){
        if(cs==s.length || ct==t.length)
            return 0;
        if(cache[cs][ct]!=-1)
            return cache[cs][ct];
        if(s[cs]==t[ct]){
            return getResult(s,cs+1,t,ct+1,cache)+1;
        }
        else{
            int c1 = getResult(s,cs+1,t,ct,cache);
            int c2 = getResult(s,cs,t,ct+1,cache);
            cache[cs][ct] = Math.max(c1,c2);
            return cache[cs][ct];
        }
    }
}

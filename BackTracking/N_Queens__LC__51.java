package BackTracking;

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
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
*/

import java.util.*;
public class N_Queens__LC__51 {
    
    static class Solution {
        static List<List<String>> ans;
        public List<List<String>> solveNQueens(int n) {
            ans = new ArrayList<>();
            char arr[][] = new char[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]='.';
                }
            }
            sol(arr,0, n);
            return ans;
        }

        public static boolean sol(char[][] arr,int row, int n){

            if(row==n){
                List<String> temp = new ArrayList<>();

                for(int i=0;i<n;i++){
                    StringBuilder dummy = new StringBuilder();
                    for(int j=0;j<n;j++){
                        dummy.append(arr[i][j]);
                    }
                    temp.add(dummy.toString());
                }
                ans.add(temp);
                return false;
            }
            for(int i=0;i<n;i++){
                if(isSafe(arr, row, i, n)){
                    arr[row][i]='Q';
                    boolean kyBakiQueenRakhPae = sol(arr, row+1, n);
                    if(kyBakiQueenRakhPae)
                        return true;
                    else{
                        arr[row][i]='.';
                    }
                }
                else{
                    arr[row][i]='.';
                }
            }
            return false;
        }

        public static boolean isSafe(char [][] arr, int row, int col, int n){
            for(int i=0;i<=row;i++){
                if(arr[i][col]=='Q')
                    return false;
            }
            int i=row;
            int j = col;
            while(i>=0 && j>=0){
                if(arr[i][j]=='Q')
                    return false;
                i--;
                j--;
            }
            i=row;
            j=col;
            while(i>=0 && j<n){
                if(arr[i][j]=='Q')
                    return false;
                i--;
                j++;
            }
            return true;
        }
    }
}

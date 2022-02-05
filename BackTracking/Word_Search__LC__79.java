/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

/**
 *
 * @author Mind_Coder
 */
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/
import java.util.*;
public class Word_Search__LC__79 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/word-search/
        */
    }
    static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] ch= word.toCharArray();
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==ch[0]){

                        boolean ans = helper(board, i, j, 0,ch, new boolean[board.length][board[0].length]);
                        if(ans==true)
                            return ans;
                    }

                }
            }
            return false;
        }

        public static boolean helper(char[][] board, int i, int j, int k,char[] ch, boolean[][] visited){
            if(k==ch.length){
                return true;
            }
            if(k>ch.length || i>=board.length || j>=board[0].length || i<0 || j<0)
                return false;
            if(visited[i][j]==true)
                return false;

            if(visited[i][j]==false && board[i][j]!=ch[k])
                return false;
            visited[i][j]=true;
            boolean c1 = helper(board, i+1,j,k+1,ch,visited);
            boolean c2 = helper(board, i-1,j,k+1,ch,visited);
            boolean c3 = helper(board, i,j+1,k+1,ch,visited);
            boolean c4 = helper(board, i,j-1,k+1,ch,visited);
            if(c1||c2||c3||c4){
                return true;
            }
            visited[i][j]=false;
            return false;
        }
    }
}

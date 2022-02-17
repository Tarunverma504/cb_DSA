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
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
Accepted
132,722
Submissions
212,069
*/
import java.util.*;
public class Jump_Game_III__LC__1306 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/jump-game-iii/
        */
    }
    static class Solution {
        public boolean canReach(int[] arr, int start) {
            return sol(arr, start, 0);
        }

        public static boolean sol(int[] arr, int start,int count){
            if(start>=arr.length || start<0)
                return false;
            if(arr[start]==0){
                return true;
            }
            if(count>=arr.length)
                return false;
            int jump= arr[start];
            boolean c1 = sol(arr, start+jump, count+1);
            if(c1==true)
                return true;
            boolean c2 = sol(arr, start-jump, count+1);
            if(c2==true)
                return true;
            return false;
        }
    }
}

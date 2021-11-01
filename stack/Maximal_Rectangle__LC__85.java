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
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 
*/

import java.util.*;
public class Maximal_Rectangle__LC__85 {
    public static void main(String arg[]){
         /*
                https://leetcode.com/problems/maximal-rectangle/
            */
    }
           
    class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int height[] =new int [matrix[0].length];
        Arrays.fill(height,0);
         int area=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int num=matrix[i][j]-'0';
                if(num==0)
                    height[j]=0;
                else{
                    height[j]=height[j]+1;
                }
            }
            area=Math.max(histogram(height),area);
        }
        return area;
    }
    
    public int histogram(int a[]){
        Stack<Integer> s1=new Stack<Integer>();
        int left[]=new int[a.length];  // store index of the previous smaller element on left if not the -1
        left[0]=-1;
        s1.push(0);
        for(int i=1;i<a.length;i++){
            while(!s1.isEmpty() && a[i]<=a[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty())
                left[i]=-1;
            else
                left[i]=s1.peek();
            s1.push(i);
        }
        Stack<Integer> s2=new Stack<Integer>();
        int right[]=new int[a.length]; // store the next smaller element if not the array.length
        s2.push(a.length-1);
        right[a.length-1]=a.length;
        for(int i=a.length-2;i>=0;i--){
            while(!s2.isEmpty() && a[i]<=a[s2.peek()]){
                s2.pop();
            }
            if(s2.isEmpty())
                right[i]=a.length;
            else
                right[i]=s2.peek();
            s2.push(i);
        }

        int ans=0;
        for(int i=0;i<a.length;i++){
            int width=right[i]-left[i]-1;
            int area=a[i]*width;
            ans=Math.max(ans,area);
        }
        return ans;
        
    }
    
    
}
}

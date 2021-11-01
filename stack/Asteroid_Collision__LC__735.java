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
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
*/
import java.util.*;
public class Asteroid_Collision__LC__735 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/asteroid-collision/
        */
    }
    class Solution {
        public int[] asteroidCollision(int[] arr) {
            if(arr.length<=1) return arr;
           Stack<Integer> st = new Stack<Integer>();
            for(int i=0;i<arr.length;i++){
                if(st.isEmpty()){
                    st.push(arr[i]);
                }
                else if(st.peek()>0 && arr[i]<0){
                    if(Math.abs(st.peek())<Math.abs(arr[i])){
                        st.pop();
                        i--;
                    }
                    else if(Math.abs(st.peek())==Math.abs(arr[i]))
                        st.pop();
                }
                else
                    st.push(arr[i]);

            }
            int ans[] = new int[st.size()];
            int i=ans.length-1;
            while(!st.isEmpty())
                ans[i--]=st.pop();
            return ans;

        }
    }
}

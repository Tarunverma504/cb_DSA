/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author Mind_Coder
 */
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
Accepted
518.4K
Submissions
1.1M
*/
import java.util.*;
public class Sliding_Window_Maximum__LC__239 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/sliding-window-maximum/
        */
    }
    static class Solution {
        class Pair{
            int val;
            int idx;
            Pair(int val, int idx){
                this.val = val;
                this.idx = idx;
            }
        }
        public int[] maxSlidingWindow(int[] a, int k) {
            if (a.length==0 || k <= 0 || a.length<k) {
                            return new int[0];
                    }
            if(a.length==1){
                return a;
            }

            int ans[] = new int[a.length-k+1];
            PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Comparator<Pair>(){
                public int compare(Pair p1, Pair p2){
                    return p2.val-p1.val;
                }

            });
            for(int i=0;i<k;i++){
                q.add(new Pair(a[i],i));
            }

            int start=0;
            int end = k;
            while(end<a.length){
                while(!q.isEmpty() && q.peek().idx<start){
                    q.poll();
                }
                ans[start]=q.peek().val;
                q.add(new Pair(a[end],end));
                start++;
                end++;
            }
            while(!q.isEmpty() && q.peek().idx<start){
                    q.poll();
            }
            ans[start]=q.peek().val;
            return ans;
        }

    }
}

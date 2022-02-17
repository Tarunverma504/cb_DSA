/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Mind_Coder
 */
/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 

Constraints:

1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in ascending order.
1 <= k <= 104
Accepted
159.7K
Submissions
410.3K
Seen this question in a real interview
*/
import java.util.*;
public class Find_K_Pairs_with_Smallest_Sums__LC__373 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
        */
    }
    static class Solution {
        class Pair{
            List<Integer> nums = new ArrayList<>();
            int sum;
            int x;
            int y;
            Pair(List<Integer> nums, int sum,int x,int y){
                this.nums=nums;
                this.sum=sum;
                this.x=x;
                this.y=y;
            }
        }
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            List<List<Integer>> ans = new ArrayList<>();

            PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Comparator<Pair>(){
               public int compare(Pair p1, Pair p2){
                   return p1.sum-p2.sum;
               }

            });



            for(int i=0;i<nums1.length;i++){  
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums1[i]);
                    temp.add(nums2[0]);
                    q.add(new Pair(temp,nums1[i]+nums2[0], i, 0));
            }

            while(!q.isEmpty() && k>0){
                Pair top=q.poll();
                ans.add(top.nums);
                if(top.y+1<nums2.length){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums1[top.x]);
                    temp.add(nums2[top.y+1]);
                    q.add(new Pair(temp, nums1[top.x]+nums2[top.y+1], top.x, top.y+1));
                }
                k--;
            }

            return ans;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Mind_Coder
 */
/*
1: You are given two integer arrays query and nums containing unique elements.
2: Here query is a subset of nums that means all elements of query are also present in nums.
3: Find all the next greater numbers for query's elements in the corresponding places of nums. If it does not exist -1 is answer for this number.
4: You are required to complete the body of the function nextGreaterI(int nums[], int query[]) which returns the answer array containing next greater element's.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: 1 <= query.length <= nums.length <= 1000
2: 0 <= query[i], nums[i] <= 10^9
3: All integers in query and nums are unique.
4: All the integers of query also appear in nums
Sample Input
4 1 2
1 3 4 2
Sample Output
3
-1
3
-1

*/

import java.util.*;
public class Next_Greater_Element_I {
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/next-greater-element-i-official/ojquestion
        */
    }
    public static int[] nextGreaterElement(int[] nums, int[] query) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        st.push(nums[nums.length-1]);
        hm.put(nums[nums.length-1],-1);
        for(int i=nums.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();
            if(st.isEmpty())
                hm.put(nums[i],-1);
            else
                hm.put(nums[i],st.peek());
            st.push(nums[i]);
        }
        // System.out.println(hm.get(1)+"ddm,f");
        int ans[] = new int[query.length];
        for(int i=0;i<query.length;i++){
            ans[i]=hm.get(query[i]);
        }
        return ans;
    }
}

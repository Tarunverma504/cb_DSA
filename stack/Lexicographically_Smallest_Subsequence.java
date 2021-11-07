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
1. Given an integer array nums and a positive integer k;
2. return the lexicographically smallest subsequence of size k;
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 10^5
2. 1 <= nums[i] <= 10^9
3. 1 <= k <= nums.length
Sample Input
8
2
4
3
3
5
4
9
6
4
Sample Output
4
2
3
3
4


*/
import java.util.*;
public class Lexicographically_Smallest_Subsequence {
    public static int[] smallest(int[] nums, int k) {
        // write your code here
        Stack<Integer> st = new Stack<Integer>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            while(!st.isEmpty() && val<st.peek() && n-i-1>=k-st.size())
                st.pop();
            if(st.size()<k)
                st.push(val);
        }
        int ans[] = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
     public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] =sc.nextInt();
        int k = sc.nextInt();
        int ans[] = smallest(arr, k);
        System.out.println(ans.length);

        for (int e : ans) {
          System.out.println(e);
        }
    }
}

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
Given an int array nums and an int target. Find two integers in nums such that the sum is closest to target.

Example 1:

Input: nums = [1, 2, 3, 4, 5], target = 10
Output: [4, 5]
Example 2:

Input: nums= [-1, 2, 1, -4], target = 4
Output: [2, 1]
*/
import java.util.*;
public class Two_Sum_Closest_to_Target {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 5, 6, 8, 15};
        Arrays.sort(arr);
        System.out.println(sol(arr, 12));
    }
    
    public static int sol(int arr[], int t){
        int l=0, r= arr.length-1;
        int closest = arr[0]+arr[1];
        while(l<r){
            int currSum = arr[l]+arr[r];
            if(Math.abs(t-currSum)< Math.abs(t-closest)){
                closest = currSum;
            }
            if(currSum<t){
                l++;
            }
            else{
                r--;
            }
        }
        return closest;
    }
}

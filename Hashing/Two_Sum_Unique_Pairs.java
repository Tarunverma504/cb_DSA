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
Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
Example 2:

Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2
Example 3:

Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
*/
import java.util.*;
public class Two_Sum_Unique_Pairs {
    
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 1, 2, 45, 46, 46};
        int target = 47;
        System.out.println(sol(arr, target));
    }
    
    public static int sol(int arr[], int k){
        Arrays.sort(arr);
        int l=0,r=arr.length-1;
        int count=0;
        while(l<r){
            if(arr[l]+arr[r]==k){
                l++;
                r--;
                while(l<r && arr[l]==arr[l-1]){
                    l++;
                }
                count++;
            }
            else if(arr[l]+arr[r]<k){
                l++;
            }
            else{
                r--;
            }
        }
        return count;
    }
}

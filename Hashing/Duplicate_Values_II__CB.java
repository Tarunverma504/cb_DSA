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
Kartik bhaiya gave monu an array 'nums' of n elements and an integer k .Find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k . monu is not good in maths help monu to solve the problem.
Return true if nums[i] = nums[j] and the absolute difference between i and j is at most k,otherwise return false.

Input Format
First line contains integer n as size of array.
Next N lines contains element of array.
Last line contains value of k.

Constraints
None

Output Format
The output will be of the boolean form (true/false).

Sample Input
4
1 
2 
3 
1
3
Sample Output
true
Explanation
None
*/
import java.util.*;
public class Duplicate_Values_II__CB {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                if(Math.abs(i-hm.get(arr[i]))<=k   ){
                    System.out.println("true");
                    return;
                }
                else{
                    System.out.println("false");
                    return;
                }
            }
            hm.put(arr[i],i);
        }
    }
}

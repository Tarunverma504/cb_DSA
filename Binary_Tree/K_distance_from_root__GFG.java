/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Tree;

/**
 *
 * @author Mind_Coder
 */
/*
Given a Binary Tree of size N and an integer K. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes should be printed from left to right. If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6 
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameter and return the value of the nodes that are at a distance k from the root. (The values are returned as vector in cpp, as ArrayList in java and list in python)
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 104
0 <= K <= 30
*/
import java.util.*;
public class K_distance_from_root__GFG {
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/k-distance-from-root/1
        */
    }
    class Node
    {
        int data;
        Node left, right;
       Node(int item)    {
            data = item;
            left = right = null;
        }
    }
    static class Tree
    {
         // Recursive function to print right view of a binary tree.
         ArrayList<Integer> ans;
         ArrayList<Integer> Kdistance(Node root, int k)
         {
              // Your code here
              ans= new ArrayList<>();
              getNodes(root, k);
              return ans;
         }

         void getNodes(Node root, int k){
             if(root==null || k<0)
                return;
            if(k==0){
                ans.add(root.data);
                return;
            }
             getNodes(root.left,k-1);
             getNodes(root.right,k-1);
         }
    }
}

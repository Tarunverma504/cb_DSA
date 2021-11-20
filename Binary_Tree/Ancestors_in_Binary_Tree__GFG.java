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
Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
Example 1:

Input:
        1
      /   \
     2     3
target = 2
Output: 1
Example 2:

Input:
         1
       /   \
      2     3
    /  \   /  \
   4    5 6    8
  /
 7
target = 7
Output: 4 2 1
Your Task:
Your task is to complete the function Ancestors() that finds all the ancestors of the key in the given binary tree.
Note:
The return type is
cpp: vector
Java: ArrayList
python: list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for the recursion stack.

Constraints:
1 ≤ N ≤ 103
*/

import java.util.*;
public class Ancestors_in_Binary_Tree__GFG {
    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    static class Solution
    {
        static  ArrayList<Integer> ans;
        public static ArrayList<Integer> Ancestors(Node root, int target)
        {
            // add your code here
            ans = new ArrayList<>();
            getList(root,target);
            return ans;
        }
        public static boolean getList(Node root, int target){
            if(root==null)
                return false;
            if(root.data==target)
                return true;
            boolean left = getList(root.left,target);
            if(left){
                ans.add(root.data);
                return true;
            }
            boolean right = getList(root.right,target);
            if(right){
                ans.add(root.data);
                return true;
            }
            return false;


        }
    }
}

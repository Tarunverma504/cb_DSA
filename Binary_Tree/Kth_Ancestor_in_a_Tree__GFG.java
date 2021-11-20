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
Given a binary tree of size  N, a node and a positive integer k., Your task is to complete the function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.


Example 1:



Input:
     K = 2
     Node = 4
Output: 1
Explanation:
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.
 

Example 2:

Input:
k=1 
node=3
      1
    /   \
    2     3

Output:
1
Explanation:
K=1 and node=3 ,Kth ancestor of node 3 is 1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1<=N<=104
1<= K <= 100

View Bookmarked Problems
Topic Tags
*/
import java.util.*;
public class Kth_Ancestor_in_a_Tree__GFG {
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1#
        */
    }
    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    static class Tree
    {
        static int count;
        static int ans;
        public int kthAncestor(Node root, int k, int node)
        {
            //Write your code here
            count=k;
            ans=-1;
            getAncestor(root,node);
            return ans;
        }

        public static boolean getAncestor(Node root, int target){
            if(root==null)
                return false;
            if(target==root.data){
                count--;
                return true;
            }
            boolean left=getAncestor(root.left,target);
            if(left){
                if(count==0 && ans==-1)
                    ans=root.data;
                count--;
                return true;
            }
            boolean right=getAncestor(root.right,target);
            if(right){
                if(count==0 && ans==-1)
                    ans=root.data;
                count--;
                return true;
            }
            return false;

        }
    }
}

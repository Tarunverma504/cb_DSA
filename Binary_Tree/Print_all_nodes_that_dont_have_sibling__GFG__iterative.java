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
Given a Binary Tree of size N, find all the nodes which don't have any sibling. Root node can not have a sibling.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: -1
Explanation: Every node has a sibling.

Your Task:  
You dont need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(Height of the tree)


Constraints:
1 ≤ N ≤ 10^4
All nodes have distinct values.
*/
import java.util.*;
public class Print_all_nodes_that_dont_have_sibling__GFG__iterative {
    public static void main(String arg[]){
        /*
        https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1#
        */
    }
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class Tree
    {
        ArrayList<Integer> noSibling(Node node)
        {
            // code here
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if(node==null)
                return ans;
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);
            while(!q.isEmpty()){
                node = q.poll();
                if(node.right==null && node.left!=null){
                    ans.add(node.left.data);
                }
                else if(node.left==null && node.right!=null){
                    ans.add(node.right.data);
                }


                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(ans.size()<1){
                ans.add(-1);
                return ans;
            }
            Collections.sort(ans);
            return ans;
        }
    }
}

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
Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.

Example 1:

Input :
        1
      /   \
     3     2

Output: 3 2 1
Explanation:
Traversing level 1 : 3 2
Traversing level 0 : 1
Example 2:

Input :
       10
      /  \
     20   30
    / \ 
   40  60

Output: 40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10

Your Task: 
You dont need to read input or print anything. Complete the function reverseLevelOrder() which takes the root of the tree as input parameter and returns a list containing the reverse level order traversal of the given tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 10^4
*/
import java.util.*;
public class Reverse_Level_Order_Traversal__GFG {
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#
        */
    }
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    class Tree
    {
        public ArrayList<Integer> reverseLevelOrder(Node root) 
        {
            // code here
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if(root==null)
                return ans;
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int n=q.size();
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(n-- > 0){
                    Node node=q.poll();
                    temp.add(node.data);
                    if(node.left!=null)
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);
                }
                for(int i=temp.size()-1;i>=0;i--){
                    ans.add(0,temp.get(i));
                }
            }
            return ans;
        }
    }     
}

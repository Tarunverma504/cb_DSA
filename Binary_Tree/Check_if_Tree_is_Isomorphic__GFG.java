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
Given two Binary Trees. Check whether they are Isomorphic or not.

Note: 
Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
For example, the following two trees are isomorphic with the following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
ISomorphicTrees

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes
Your Task:
You don't need to read input or print anything. Your task is to complete the function isomorphic() that takes the root nodes of both the Binary Trees as its input and returns True if the two trees are isomorphic. Else, it returns False. (The driver code will print Yes if the returned values are true, otherwise false.)

 

Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.

Constraints:
1<=Number of nodes<=105
*/
import java.util.*;
public class Check_if_Tree_is_Isomorphic__GFG {
    
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1#
        */
    }
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    class Solution  
    { 
        // Return True if the given trees are isomotphic. Else return False.
        boolean isIsomorphic(Node root1, Node root2)  
        { 
             // code here.
             if(root1==null && root2==null)
                return true;
            if(root1==null || root2==null)
                return false;
            if(root1.data!=root2.data)
                return false;
            boolean comp1 = isIsomorphic(root1.left,root2.right);
            boolean comp2 = isIsomorphic(root1.right,root2.left);
            boolean comp3 = isIsomorphic(root1.left,root2.left);
            boolean comp4 = isIsomorphic(root1.right,root2.right);
            if((comp1==true && comp2==true) || (comp3==true && comp4==true))
                return true;
            return false;
        }

    }    
}

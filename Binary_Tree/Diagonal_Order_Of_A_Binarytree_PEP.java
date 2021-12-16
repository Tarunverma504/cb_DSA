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
1. Given a Binary Tree, print Diagonal Order of it. 
2. For more Information watch given video link below.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
0 -> 1 1 
1 -> 1 1 1 
2 -> 1 1 

*/
import java.util.*;
public class Diagonal_Order_Of_A_Binarytree_PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/diagonal-order-of-a-binarytree/ojquestion
        */
    }
     public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>>  ans = new ArrayList<ArrayList<Integer>> ();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size-- > 0){
                TreeNode rn = q.remove();
                while(rn!=null){
                    temp.add(rn.val);
                    if(rn.left!=null)
                        q.add(rn.left);
                    rn = rn.right;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

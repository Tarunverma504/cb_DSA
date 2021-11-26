/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
*/
import java.util.*;
public class All_Nodes_Distance_K_in_Binary_Tree__LC__863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        static ArrayList<TreeNode> path;
      static List<Integer> ans;
      public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
          path = new ArrayList<>();
          ans=new ArrayList<Integer>();
          findNode(root,target);
          for(int i=0;i<path.size();i++){
              printKLevelDown(path.get(i), k-i, i==0?null:path.get(i-1));
          }
          return ans;
      }

      public static boolean findNode(TreeNode root,TreeNode data){

            if(root==null)
              return false;
            if(root== data){
                path.add(root);
                return true;
            }

            boolean left = findNode(root.left,data);
            if(left){
                path.add(root);
                return true;
            }

              boolean right = findNode(root.right,data);
              if(right){
                  path.add(root);
                  return true;
              }
              return false;
        }
      public static void printKLevelDown(TreeNode root, int k,TreeNode blocker){
            if(root==null || k<0 || root==blocker)
              return ;
            if(k==0){
                ans.add(root.val);
                return ;
            }
            printKLevelDown(root.left, k-1, blocker);
            printKLevelDown(root.right, k-1, blocker);
        }
  }
}

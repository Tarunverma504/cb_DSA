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
1. Given a Binary Tree, print Vertical Order of it. 
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
public class Vertical_Order_Traversal_Of_A_Binarytree__PEP {
    
    public static void main(String arg[]){
        /*
            https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/vertical-order-traversal-of-a-binarytree/ojquestion
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
    
    public static class Pair{
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
   
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxl=0;
        int maxr=0;
        while(!q.isEmpty()){
            int nn = q.size();
            while(nn-- > 0){
                Pair n = q.poll();
                maxl = Math.min(maxl, n.pos);
                maxr = Math.max(maxr, n.pos);
                if(h.get(n.pos)==null)
                    h.put(n.pos, new ArrayList<>());
                h.get(n.pos).add(n.node.val);
                if(n.node.left!=null){
                    q.add(new Pair(n.node.left,n.pos-1));
                }
                if(n.node.right!=null){
                    q.add(new Pair(n.node.right, n.pos+1));
                }
                
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> ();
        for(int i=maxl;i<=maxr;i++){
            ans.add(h.get(i));
        }
        
        return ans;
    }
}

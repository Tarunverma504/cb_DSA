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
Given a Binary Tree Print all the leaf nodes.

Input Format
Level order input of the binary tree

Constraints
Total no of nodes <1000

Output Format
All leaf nodes from left to right in single line

Sample Input
1
2 3
4 5
6 7
-1 -1
-1 -1
-1 -1
-1 -1
Sample Output
4 5 6 7
*/
import java.util.*;
public class Print_All_Leaf_Nodes__CB {
    static class Node{
        int val;
        Node left=null;
        Node right=null;
        Node(int data){
            this.val=data;
        }
    }
	static Scanner sc = new Scanner(System.in);
    public static void main(String arg[]){

        Node root= construct();
		getLeafNodes(root);
    }

	public static void getLeafNodes(Node root){
		if(root==null)
			return ;
			if(root.left==null && root.right==null){
				System.out.print(root.val+" ");
				return ;
			}
			getLeafNodes(root.left);
			getLeafNodes(root.right);
	}
	public static Node construct(){
        int r = sc.nextInt();
        if(r==-1)
            return  null;
        Node root = new Node(r);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node p = q.remove();
            int a = sc.nextInt();
            int b= sc.nextInt();
            if(a!=-1){
                Node temp = new Node(a);
                p.left=temp;
                q.add(temp);
            }
            if(b!=-1){
                Node temp = new Node(b);
                p.right=temp;
                q.add(temp);
            }
        }
        return root;
    }
}

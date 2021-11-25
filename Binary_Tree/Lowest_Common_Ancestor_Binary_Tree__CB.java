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
Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL next two line contains 2 element of BT

Constraints
None

Output Format
Display the LCA value.

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
50
60
Sample Output
10
*/
import java.util.*;
public class Lowest_Common_Ancestor_Binary_Tree__CB {
    static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val= val;
		}
	}

	static Scanner sc = new Scanner(System.in);
	public static Node construct(){
		int val = sc.nextInt();
		Node node = new Node(val);
		boolean hlc = sc.nextBoolean();
		if(hlc){
			node.left=construct();
		}

		boolean hrc = sc.nextBoolean();
		if(hrc)
			node.right=construct();
		return node;

	}
    public static void main(String args[]) {
		Node root= construct();
		int p=sc.nextInt();
		int q=sc.nextInt();

		Node ans = lca(root,p,q);
		if(ans==null)
			System.out.println("NULL");
		else
			System.out.println(ans.val);
    }

	public static Node lca(Node root,int p,int q){
		if(root==null)
			return null;
		if(root.val==p || root.val==q){
			return root;
		}

		Node leftAns = lca(root.left,p,q);
		Node rightAns = lca(root.right,p,q);

		if(leftAns!=null && rightAns!=null)
			return root;
		if(leftAns!=null)
			return leftAns;
		return rightAns;
		
	}
}

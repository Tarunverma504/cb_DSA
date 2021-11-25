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
Given a binary tree. Print the level order traversal, make sure each level start at a new line.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Print the level order in which the different levels are in different lines, all the values should be in a space separated manner

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10 
20 30 
40 50 60 73
*/
import java.util.*;
public class Level_Order_New_Line__Binary_Tree__CB {
    static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val= val;
		}
	}
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
	static Scanner sc = new Scanner(System.in);
	public static void main(String arg[]){
		Node root= construct();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int n=q.size();
			while(n-- > 0){
				Node node= q.poll();
				System.out.print(node.val+" ");
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			System.out.println();
		}
	}
}

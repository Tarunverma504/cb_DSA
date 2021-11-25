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
Given a binary tree, remove all the leaves from the tree

Input Format
Enter the value of the nodes of the tree

Constraints
None

Output Format
Display the tree in which all the leaves have been removed in pre-order traversal in the following format :
Left->data => Root->data <= Right->Data
Output END if left or right node is NULL

Sample Input
50 true 12 true 18 false false false false
Sample Output
12 => 50 <= END
END => 12 <= END
*/
import java.util.*;
public class Remove_the_leaves_Binary_Tree__CB {
    public static void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			display(node.left);
			display(node.right);
		}

		static class Node{
		int data;
		Node left;
		Node right;
		Node(int val){
			this.data= val;
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
		root= removeLeaf(root);
		display(root);
	}

	public static Node  removeLeaf(Node root){
		if(root==null)
			return null;
		if(root.left==null && root.right ==null)
			return null;
		root.left = removeLeaf(root.left);
		root.right = removeLeaf(root.right);
		return root;
	}
}

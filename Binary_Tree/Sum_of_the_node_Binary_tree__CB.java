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
Given a binary tree find sum of all the nodes.

Input Format
Enter the value of the node then the Boolean choice i.e whether the node has a left child , then enter the left child's data . The input acts in a recursive manner i.e when the left child's children are made only then we move onto the parent's right child

Constraints
None

Output Format
Display the sum of all the nodes

Sample Input
50 true 25 true 12 false false false true 75 true 62 false false false
Sample Output
224
Explanation
If we enter the following values

50 true 25 true 12 false false false true 75 true 62 false false false

the tree would look like :

25 => 50 <= 75

12 => 25 <= END

END => 12 <= END

62 => 75 <= END

END => 62 <= END
*/
import java.util.*;
public class Sum_of_the_node_Binary_tree__CB {
    static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Main m = new Main();
            Sum_of_the_node_Binary_tree__CB m = new Sum_of_the_node_Binary_tree__CB();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.sumOfNodes());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {
			
			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public int sumOfNodes() {
			return this.sumOfNodes(this.root) ;
		}
		
		private int sumOfNodes(Node node) {
			
			// write your code here
			Queue<Node> q = new LinkedList<>();
			q.add(node);
			int sum=0;
			while(!q.isEmpty()){
				Node n = q.remove();
				sum+=n.data;
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
			}
			return sum;
			
		}
	}
}

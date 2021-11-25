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
Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even levels should be printed from right to left.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display the values in zigzag level order in which each value is separated by a space

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10 30 20 40 50 60 73 
*/
import java.util.*;
public class Level_Order_Zigzag__Binary_Tree__CB {
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
		int i=0;
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int n=q.size();
			i++;
			ArrayList<Integer> a = new ArrayList<>();
			while(n-- > 0){
				Node node= q.poll();
				if(i%2!=0)
					System.out.print(node.val+" ");
				else{
					a.add(node.val);
				}
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			for(int j=a.size()-1;j>=0;j--){
				System.out.print(a.get(j)+" ");
			}
		}
		
	}
}

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
Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

Input Format
First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.

Constraints
None

Output Format
Display the root to leaf path whose sum is equal to k.

Sample Input
10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
60
Sample Output
10 20 30
Explanation
The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.
*/
import java.util.*;
public class Root_to_Leaf_Binary_Tree__CB {
    static Scanner sc = new Scanner(System.in);
	static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val=val;
		}
	}

	public static Node construct(){
		int val = sc.nextInt();
		Node node = new Node(val);

		boolean hlc = sc.nextBoolean();
		if (hlc) {
				node.left = construct();
			}

			// right
			boolean hrc = sc.nextBoolean();

			if (hrc) {
				node.right = construct();
			}

			// return
			return node;
	}
	static ArrayList<Integer> a;
	public static void main(String args[]) {
		Node root = construct();
		int sum=sc.nextInt();
		a = new ArrayList<>();
		if(root==null)
			return;
		getPath(root,sum,0);
		// System.out.println(a);
		for(int i=a.size()-1;i>=0;i--){
			System.out.print(a.get(i)+" ");
		}
    }
	public static boolean getPath(Node root, int target, int csum){
		if(root==null){
			return false;
		}
		if(root.left==null && root.right==null){
			if(root.val+csum==target){
				a.add(root.val);
				return true;
			}
		}
		boolean left = getPath(root.left,target,csum+root.val);
		if(left){
			//System.out.print(root.val+" ");
			a.add(root.val);
			return true;
		}
			
		boolean right = getPath(root.right,target,csum+root.val);
		if(right){
			//ystem.out.print(root.val+" ");
			a.add(root.val);
			return true;
		}
			
		return false;

	}

}

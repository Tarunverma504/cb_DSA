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
Given two trees check if they are structurally identically. Structurally identical trees are trees that have same structure. They may or may not have the same data though.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
1 <= N <= 10^4

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The given two trees have the exact same structure and hence we print true.
*/
import java.util.*;
public class Structurally_Identical_Binary_Tree__CB {
    static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val = val;
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
	public static void main(String[] args) {
		Node root1 = construct();
		Node root2 = construct();
		
		System.out.println(isSameStructure(root1,root2));
	}

	public static boolean isSameStructure(Node root1,Node root2){
		if(root1==null && root2==null)
			return true;
		if(root1!=null && root2!=null){
			boolean isLeftSame = isSameStructure(root1.left,root2.left);
			boolean isRightSame = isSameStructure(root1.right,root2.right);
			return isLeftSame && isRightSame; 
		}
		return false;
        }
}

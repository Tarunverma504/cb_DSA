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
Given a Binary tree check if it is balanced i.e. depth of the left and right sub-trees of every node differ by 1 or less.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
1 <= No of nodes <= 10^5

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The tree looks like

             10
          /       \
       20           30
    /     \       /     \
   40      50    60      73
The given tree is clearly balanced as depths of the left and right sub-trees of every node differ by 1 or less.
*/
import java.util.*;
public class Is_Balanced_Binary_Tree__CB {
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
        boolean ans = isBalanced(root);
        System.out.println(ans);
    }

    public static boolean isBalanced(Node root){
        if(root==null)
            return true;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        boolean isRootBalanced = Math.abs(leftHeight- rightHeight)<=1;
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isRootBalanced && isLeftBalanced && isRightBalanced;
    }

    public static int Height(Node root){
        if(root==null)
            return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        return Math.max(left,right)+1;
    }
}

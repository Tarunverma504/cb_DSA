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
Given a Binary tree, write code to create a separate array list for each level. You should return an arraylist of arraylist.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display the resulting arraylist of arraylist according to given sample examples.

Sample Input
50 true 12 true 18 false false true 13 false false false
Sample Output
[[50], [12], [18, 13]]
*/
import java.util.*;
public class ArrayList_of_levels_Binary_Tree__CB {
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
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int n=q.size();
			i++;
			ArrayList<Integer> a = new ArrayList<>();
			while(n-- > 0){
				Node node= q.poll();
					a.add(node.val);
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			ans.add(a);
		}
		System.out.println(ans);
		
	}
}

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
Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. Print all sums through different vertical lines.

Input Format
Level order traversal of the binary tree where -1 represents NULL child

Constraints
-10^5<=Nodes.data<=10^5

Output Format
Right View of the tree

Sample Input
1 2 5 8 4 6 3 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output
1 5 3 
Explanation
None
*/
import java.util.*;
public class Right_View_of_a_Binary_Tree__CB {
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
       getRightView(root);
        

    }

    public static void getRightView(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root==null)
            return;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int size=q.size();
           for(int i=0;i<n;i++){
                Node node = q.poll();
                if(i==n-1){
                    System.out.print(node.val+" ");
                }
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
        }
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

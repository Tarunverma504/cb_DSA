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
Left view of a Binary Tree is set of nodes visible when tree is visited from left side.

Input Format
The first line of the input contains level order traversal of the tree as space separated integers . In the level order traversal , -1 represent a null child while any other value represent a node of the tree.

Constraints
1<=number of nodes in the tree <=10^5

Output Format
Space separated node values as visible from the left side of the binary tree.

Sample Input
1 2 2 -1 -1 -1 -1
Sample Output
1 2
Explanation
level order traversal is
1
2 2
so the output is 1 2
*/
import java.util.*;
public class Left_View_of_a_Binary_Tree__CB {
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
       getLeftView(root);
        

    }

    public static void getLeftView(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root==null)
            return;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int size=q.size();
           for(int i=0;i<n;i++){
                Node node = q.poll();
                if(i==0){
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

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
Given a binary tree of size N, you have to count number of nodes in it. For example, count of nodes in below tree is 4.

        1
     /      \
   10      39
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each testcase in new line, print the number of nodes.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function getSize().

Constraints:
1 <= T <= 30
1 <= N <= 104
Example:
Input:
2
1 2 3
10 5 9 N 1 3 6 

Output:
3
6

Explanation:
Testcase 2: Given Tree is :
                                10
                             /        \
                           5          9
                             \       /     \
                              1    3       6
There are six nodes in the tree .

*/
import java.util.*;
public class Size_of_Binary_Tree__GFG {
    public static void main(String arg[]){
        /*
            https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1
        */
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static class Tree
    {
            public static int getSize(Node temp)
            {
            //add Code here.
             if(temp==null)
                return 0;
            int leftPart=getSize(temp.left);  //if we get size of left subtree and
            int rightPart=getSize(temp.right); //size of right subtree
            return leftPart+rightPart+1; //then we add them and add 1 more for thr root node that give size of tree

        }
    }
}

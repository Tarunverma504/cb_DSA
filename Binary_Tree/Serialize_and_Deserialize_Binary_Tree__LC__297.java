package Binary_Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
*/
import java.util.*;
public class Serialize_and_Deserialize_Binary_Tree__LC__297 {
 
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
        */
    }
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serial(root,sb);
            return sb.toString();
        }
        public static void serial(TreeNode root, StringBuilder sb){
            if(root==null){
                sb.append("null,");
                return;
            }
            sb.append(root.val+",");
            serial(root.left, sb);
            serial(root.right, sb);
        }

        // Decodes your encoded data to tree.
        static int idx;
        public TreeNode deserialize(String data) {
            idx=0;
            String arr[] = data.split(",");
            return deserial(arr);
        }

        public static TreeNode deserial(String arr[]){
            if(idx>=arr.length || arr[idx].equals("null")){
                idx++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
            root.left = deserial(arr);
            root.right = deserial(arr);
            return root;

        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
}

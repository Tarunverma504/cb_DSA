/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Mind_Coder
 */
/*
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Example
Operations are requested as follows:

add ed
add eddie
add edward
find ed
add edwina
find edw
find a
Three  operations include the names 'ed', 'eddie', and 'edward'. Next,  matches all  names. Note that it matches and counts the entire name 'ed'. Next, add 'edwina' and then find 'edw'.  names match: 'edward' and 'edwina'. In the final operation, there are  names that start with 'a'. Return the array .

Function Description

Complete the contacts function below.

contacts has the following parameters:

string queries[n]: the operations to perform
Returns

int[]: the results of each find operation
Input Format

The first line contains a single integer, , the number of operations to perform (the size of ).
Each of the following  lines contains a string, .

Constraints

 and  contain lowercase English letters only.
The input does not have any duplicate  for the  operation.
Sample Input

STDIN           Function
-----           --------
4               queries[] size n = 4
add hack        queries = ['add hack', 'add hackerrank', 'find hac', 'find hak']
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

Add a contact named hack.
Add a contact named hackerrank.
Find the number of contact names beginning with hac. Both name start with hac, add  to the return array.
Find the number of contact names beginning with hak. neither name starts with hak, add  to the return array.
*/

import java.util.*;
public class Your_Contacts_Trie {
    
    public static void main(String arg[]){
        /*
            https://www.hackerrank.com/challenges/contacts/problem?isFullScreen=false
        */
    }
    static class Node{
        int val;
        Map<Character, Node> children;
        int count=0;
        public Node(int val){
            this.val = val;
            this.children = new HashMap<>();
            this.count=0;
        }
    }
    static Node root;
    public static List<Integer> contacts(List<List<String>> q) {
    // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        root=new Node('*');
        for(int i=0;i<q.size();i++){
            if(q.get(i).get(0).equals("add")){
                insert(q.get(i).get(1));
            }
            else{
                ans.add(find(q.get(i).get(1)));
            }
        }
        return ans;
    }
    
    public static void insert(String word){
        Node current = root;
        for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
            if(current.children.containsKey(cc)){
                current = current.children.get(cc);
            }
            else{
                Node nn = new Node(cc);
                current.children.put(cc, nn);
                current = nn;
            }
            current.count++;

        }
    }
    
    public static int find(String word){
        Node current = root;
        for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
            if(current.children.containsKey(cc)){
                current = current.children.get(cc);
            }           
            else{
                return 0;
            }
        
        }
        return current.count;
    }
}

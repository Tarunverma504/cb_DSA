package Heap;

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
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
*/
import java.util.*;
public class Implement_Trie_Prefix_Tree__LC__208 {
    class Trie {
        class Node{
            char val;
            Map<Character, Node> children;        
            boolean isMarked;

            public Node(char val){
                this.val=val;
                this.children = new HashMap<>();
                this.isMarked = false;
            }
        }
        Node root;
        public Trie() {
            root = new Node('*');
        }

        public void insert(String word) {
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

            }
            current.isMarked = true;
        }

        public boolean search(String word) {
             Node current = root;
            for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
                if(current.children.containsKey(cc)){
                    current = current.children.get(cc);
                }
                else{
                   return false;
                }

            }
            return current.isMarked;
        }

        public boolean startsWith(String word) {
             Node current = root;
            for(char cc:word.toCharArray()){//['K', 'a', 'r', 'n']
                if(current.children.containsKey(cc)){
                    current = current.children.get(cc);
                }
                else{
                   return false;
                }

            }
            return true;
        }
    }
}

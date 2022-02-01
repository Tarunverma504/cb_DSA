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
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
*/
import java.util.*;
public class Replace_Words__LC__648 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/replace-words/
        */
    }
    static class Solution {
        static class Node{
            char val;
            Map<Character,Node> children;
            boolean isWord;
            Node(char val){
                this.val = val;
                this.children = new HashMap<>();
                this.isWord=false;

            }
        }
        public String replaceWords(List<String> dict, String sentence) {
            Node root = buildTrie(dict);
            String[] s = sentence.split(" ");
            return replaceWord(s, root).trim();
        }

        public static String replaceWord(String[] s, Node root){
            StringBuilder str= new StringBuilder();
            for(String ss: s){
                str.append(getWord(ss, root));
                str.append(" ");
            }
            return str.toString();
        }

        public static String getWord(String s,Node root){
            Node current = root;
            StringBuilder dummy= new StringBuilder();
            for(char cc:s.toCharArray()){
                dummy.append(cc);
                if(current.children.containsKey(cc)){
                    current = current.children.get(cc);
                    if(current.isWord){
                        return dummy.toString();
                    }
                }
                else{
                    return s;
                }
            }
            return dummy.toString();
        }

        public static Node buildTrie(List<String> dict){
            Node root = new Node(' ');
            for(int i=0;i<dict.size();i++){
                String str=dict.get(i);
                Node current=root;
                for(char cc:str.toCharArray()){
                    if(current.children.containsKey(cc)){
                        current=current.children.get(cc);
                    }
                    else{
                        Node nn = new Node(cc);
                        current.children.put(cc, nn);
                        current = nn;
                    }
                }
                current.isWord = true;
            }
            return root;
        }
    }
}

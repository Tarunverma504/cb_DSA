/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

/**
 *
 * @author Mind_Coder
 */
/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
Accepted
713.5K
Submissions
2.1M
Seen this question in a real interview
*/
import java.util.*;
public class Word_Ladder__LC__127 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/word-ladder/
        */
    }
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord))  // means final word is not present so we can't make it
                return 0;
            HashMap<String, Boolean> vis = new HashMap<String, Boolean>(); //store the visited status of the word
            for(int i=0;i<wordList.size();i++){
                vis.put(wordList.get(i), false);
            }

            Queue<String> q = new LinkedList<String>();  //use for bfs
            q.add(beginWord);
            int level=1;
            vis.put(beginWord, true);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    String w = q.poll();
                    if(w.equals(endWord))
                        return level;
                    wordMatch(w, vis, q);
                }
                level++;
            }
            return 0;
        }

        //utility function in which we change single character at time and make permuations and 
        //check wheather word exit in given list or not
        //uif exit then add it to queue and make visited status true;
        public static void wordMatch(String w, HashMap<String, Boolean> vis, Queue<String> q){
            for(int i=0;i<w.length();i++){
                char word[] = w.toCharArray();
                for(int j=0;j<26;j++){
                    char c = (char)('a'+j);
                    word[i]=c;
                    String s = String.valueOf(word);
                    if(vis.containsKey(s)&& vis.get(s)==false){
                        q.add(s);
                        vis.put(s, true);
                    }

                }
            }
        }
    }
}

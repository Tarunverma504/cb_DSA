package DP;

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
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

import java.util.*;
public class Word_Break__LC__139 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/word-break/
        */
    }
    static class Solution {
        Map<String , Boolean> map = new HashMap<>();
        public boolean wordBreak(String s, List<String> wordDict) {
            if(wordDict.contains(s))
                return true;
            if(map.containsKey(s))
                return map.get(s);
            for(int i=1;i<=s.length();i++){
                String left = s.substring(0, i);
                if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict) ){

                    map.put(s, true);
                    return true;
                }

            }
            map.put(s, false);
            return false;
        }
    }
}

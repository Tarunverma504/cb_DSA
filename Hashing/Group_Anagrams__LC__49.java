package Hashing;

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
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/
import java.util.*;
public class Group_Anagrams__LC__49 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/group-anagrams/
        */
    }
    static class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> h = new HashMap<>();
        for(int i=0;i<str.length;i++){
            String s = str[i];
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            s=new String(arr);
            if(!h.containsKey(s)){
                h.put(s, new ArrayList<String>());
            }
            List<String> temp = h.get(s);
            temp.add(str[i]);
            h.put(s,temp);
            
        }
        for(Map.Entry<String, List<String>> hm : h.entrySet()){
            ans.add(hm.getValue());
        }
        return ans;
    }
}
}

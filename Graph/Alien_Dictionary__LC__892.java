/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Mind_Coder
 */
/*
Description
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

You may assume all letters are in lowercase.
The dictionary is invalid, if a is prefix of b and b is appear before a.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return the smallest in normal lexicographical order
Example
Example 1:

Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"
Example 2:

Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"
*/
import java.util.*;
public class Alien_Dictionary__LC__892 {
    public static String alienOrder(String[] words) {

		int[] indegree = new int[26];
		Map<Character, List<Character>> adJlist = new HashMap<>();
		for (String word : words) {
			for (char cc : word.toCharArray()) {
				adJlist.putIfAbsent(cc, new ArrayList<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];// wrt
			String word2 = words[i + 1];// wrf
			if(word1.startsWith(word2) && word1.length() > word2.length()) {
				return "";
			}

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					List<Character> neighbours = adJlist.get(word1.charAt(j));
					neighbours.add(word2.charAt(j));
					adJlist.put(word1.charAt(j), neighbours);
					indegree[word2.charAt(j) - 'a']++;
					break;
				}
			}

		}

		// topological sorting
		Queue<Character> bfs = new LinkedList<>();
		for (char v : adJlist.keySet()) {
			if (indegree[v - 'a'] == 0) {
				bfs.add(v);
			}
		}

		System.out.println(bfs);
		StringBuilder sb = new StringBuilder();
		while (!bfs.isEmpty()) {
			char front = bfs.poll();
			//System.out.print(front);
			sb.append(front);

			List<Character> neighbours = adJlist.get(front);
			for (char neighbour : neighbours) {
				indegree[neighbour - 'a']--;
				if (indegree[neighbour - 'a'] == 0)
					bfs.add(neighbour);
			}
		}
		//
		//System.out.println(Arrays.toString(indegree));
		//System.out.println(adJlist);
		return sb.toString().length() < adJlist.size() ? "" : sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "wrt","wrf","er","ett","rftt"};
		System.out.println(alienOrder(words));
	}
}

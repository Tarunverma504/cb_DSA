/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

/**
 *
 * @author Mind_Coder
 */
/*
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 

Constraints:

1 <= s.length <= 16

s contains only lower case English letters.

Accepted
18.6K
Submissions
34.8K
*/
import java.util.*;
public class Split_a_String_Into_the_Max_Number_of_Unique_Substrings__LC_1593 {
    static class Solution {
        public int maxUniqueSplit(String s) {
            HashSet<String> h = new HashSet<>();
            return sol(s, h);
        }
        public static int sol(String s, HashSet<String> set){
            int max=0;
            for(int i=1;i<=s.length();i++){
                String candidate = s.substring(0, i);
                if(!set.contains(candidate)){
                    set.add(candidate);
                    max= Math.max(max, sol(s.substring(i),set)+1);
                    set.remove(candidate);
                }
            }
            return max;
        }
    }
}

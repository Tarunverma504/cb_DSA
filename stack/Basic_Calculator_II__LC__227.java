package stack;

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
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/
import java.util.*;
public class Basic_Calculator_II__LC__227 {
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/basic-calculator-ii/
        */
    }
    static class Solution {
        public int calculate(String s) {
            char sign='+';
            Stack<Integer> st = new Stack<Integer>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(Character.isDigit(ch)){
                    int val=0;
                    while(i<s.length() && Character.isDigit(s.charAt(i))){
                        val=val*10+(s.charAt(i)-'0');
                        i++;
                    }
                    i--;
                    if(sign=='+'){
                        val=val*1;
                        st.push(val);

                    }
                    else if(sign=='-'){
                        val=val*-1;
                        st.push(val);

                    }
                    else if(sign=='*'){
                        int temp=st.pop();
                        temp=temp*val;
                        st.push(temp);

                    }
                    else if(sign=='/'){
                         int temp=st.pop();
                        temp=temp/val;
                        st.push(temp);
                    }

                }
                else if(ch!=' '){
                    sign=ch;
                }
            }
            int ans=0;
            while(!st.isEmpty()){
                ans+=st.pop();
            }
            return ans;
        }
    }
}

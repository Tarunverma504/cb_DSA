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
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
*/
import java.util.*;
public class Basic_Calculator__LC__224 {
    public  static void main(String arg[]){
        /*
            https://leetcode.com/problems/basic-calculator/
        */
    }
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> st = new Stack<Integer>();
            int sum=0;
            int sign=1;
            for(int i=0;i<s.length();i++){
                char ch =s.charAt(i);
                if(Character.isDigit(ch)){
                    int val=0;
                    while(i<s.length() && Character.isDigit(s.charAt(i))){
                        val=val*10+(s.charAt(i)-'0');
                        i++;
                    }
                    i--;
                    val=val*sign;

                    sum+=val;
                    sign=1;
                }
                else if(ch=='('){
                    st.push(sum);
                    st.push(sign);
                    sign=1;
                    sum=0;

                }
                else if(ch==')'){
                    sum=sum*(st.pop());
                    sum=sum+st.pop();
                    sign=1;

                }
                else if(ch=='-'){
                    sign=sign*-1;
                }
            }

            return sum;
        }
    }
}

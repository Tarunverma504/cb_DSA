/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Mind_Coder
 */
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Input Format
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.

Constraints
Output Format
For each test case, in a new line, evaluate the postfix expression and print the value.

Sample Input
2
231*+9-
123+*8-
Sample Output
-4
-3
Explanation
Let the given expression be “2 3 1 * + 9 -“.
We scan all elements one by one.
1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’
2) Scan ‘3’, again a number, push it to stack, stack now contains ‘2 3’ (from bottom to top)
3) Scan ‘1’, again a number, push it to stack, stack now contains ‘2 3 1’
4) Scan ‘*’, it’s an operator, pop two operands from stack, apply the * operator on operands, we get 3*1 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘2 3’.
5) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, we get 3 + 2 which results in 5. We push the result ‘5’ to stack. Stack now becomes ‘5’.
6) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘5 9’.
7) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, we get 5 – 9 which results in -4. We push the result ‘-4’ to stack. Stack now becomes ‘-4’.
8) There are no more elements to scan, we return the top element from stack (which is the only element left in stack).
*/

import java.util.*;
public class Evaluate_an_Expression {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            String expr= sc.next();
            Stack<Integer> st=new Stack<Integer>();
            for(int i=0;i<expr.length();i++){
                char ch=expr.charAt(i);
                if(ch>='0' && ch<='9'){
                    int x=(int) ch-'0';
                    st.push(x);
                }
                else{
                    int num2=st.pop();
                    int num1=st.pop();
                    int res=operation(num1,num2,ch);
                    st.push(res);
                }
            }
            System.out.println(st.peek()); 
            t--;
        }
    }

    public static  int operation(int num1,int num2,char op){
        if(op=='+')
            return num1+num2;
        else if(op=='-')
            return num1-num2;
        else if(op=='*')
            return num1*num2;
        else    
            return num1/num2;
    }
}


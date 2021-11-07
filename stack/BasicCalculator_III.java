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
1. Implement a basic calculator to evaluate a simple expression string.
2. String will contain only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
3. All intermediate results will be in the range of [-2^31, 2^31 - 1].
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= s.length <= 10^4
2. s consists of digits, '+', '-', '*', '/', '(', and ')'.
3. s is a valid expression.
Sample Input
2*(5+5*2)/3+(6/2+8)
Sample Output
21


*/
import java.util.*;
public class BasicCalculator_III {
    public static class Pair{
      Stack<Integer> st;
      char sign;
      Pair(Stack<Integer> s, char c){
          st=s;
          sign=c;
      }
      
    }
    public static void  cal(Stack<Integer> st,int val,char sign){
      
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
    public static int calculate(String s) {
            char sign='+';
            Stack<Pair> stp = new Stack<Pair>();
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
                    cal(st,val,sign);
                    

                }
                else if(ch=='('){
                    stp.push(new Pair(st,sign));
                    sign='+';
                    st=new Stack<>();
                    
                }
                else if(ch==')'){
                    int val=0;
                    while(!st.isEmpty())
                        val+=st.pop();
                    Pair p = stp.pop();
                    st=p.st;
                    sign=p.sign;
                    cal(st,val,sign);
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
     public static void main(String[] args){
         Scanner sc= new Scanner(System.in);
          int result = calculate(sc.nextLine()  );
          System.out.println(result);
     }
}

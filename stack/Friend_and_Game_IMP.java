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
Two friends were playing a mind game, the game was as follows :
Both players will get 4-4 chances each, player 1 will always go first, both players takes turn alternatively . They will roll the dice 8 times and note it, if even number comes that means Increasing else Decreasing, after 8 dice roll will start. so,the game is both players have to build the string with non repeating digit(1-9), whose value is minimum possible and the follows the relation . your task is to print final number.



For example, suppose after 2-2 turns they got relation as Increasing, Decreasing, Decreasing, Increasing. In this case final String will contains value from 1 to 5 And will be holding this relation between each consecutive digit, we have to print such minimum possible String. Here the answer will be "14325".(1,4):Increasing, (4,3) :Decreasing, (3,2):Decreasing,(2,5):Increasing


Input Format
First line contains T, denoting the number of test case
Second line Contains String of length 8, representing value appears on dice after it is rolled.

Constraints
T<1000
String of length==8

Output Format
Print smallest possible number following the relation

Sample Input
1
25426251
Sample Output
132456987
*/

import java.util.*;
public class Friend_and_Game_IMP {
    public static void main (String args[]) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            String str=sc.next();
            String ans="";
            Stack<Integer> st= new Stack<Integer>();
            for(int i=0;i<=str.length();i++){
                st.push(i+1);
                if(i==str.length() || (str.charAt(i)-'0')%2==0){
                    while(!st.isEmpty()){
                        ans+=st.pop();
                    }
                }

            }
            System.out.println(ans);

            t--;
        }
    }
}

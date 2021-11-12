/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Mind_Coder
 */
/*
Given a number N, now you have to generate all all binary numbers with decimal values from 1 to n.

Input Format
First and only line of input contains integer n.

Constraints
1<=N<=10^5

Output Format
print all binary numbers with decimal values from 1 to N.

Sample Input
2
4
Sample Output
1 10
1 10 11 100 
Explanation
Testcase 1:Binary numbers from 1 to 2 are 1 and 10.
*/
import java.util.*;
public class Generate_binary_numbers__CB {
    public static void main (String args[]) {
		Scanner sc= new Scanner (System.in);
		int n=sc.nextInt();
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		for(int i=0;i<n;i++){
			String temp=q.remove();
			System.out.print(temp+" ");
			q.add(temp+"0");
			q.add(temp+"1");
		}
    }
}

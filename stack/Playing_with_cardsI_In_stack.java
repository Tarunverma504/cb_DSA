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
You are at a casino. There are N stacked cards on pile . Each card has a number written on it. Then there will be Q iterations. In ith iteration, you start picking up the cards in Ai-1th pile from the top one by one and check whether the number written on the card is divisible by the ith prime number. If the number is divisible, you stack that card on pile Bi. Otherwise, you stack that card on pile Ai. After Q iterations, cards can only be on pile B1, B2, B3, . . . BQ, AQ . Output numbers on these cards from top to bottom of each piles in order of B1, B2, B3, . . . BQ, AQ .

Input Format
First line contains N and Q. The next line contains N space separated integers representing the initial pile of cards i.e., A0. The leftmost value represents the bottom plate of the pile.

Constraints
N < 10^5
Q < 10^5
|Ai| < 10^9

Output Format
Output N lines, each line containing the number written on the card.

Sample Input
5 1
3 4 7 6 5
Sample Output
4
6
3
7
5
Explanation
Initially:

A0 = [3, 4, 7, 6, 5]<-TOP

After 1st iteration:

A0 = []<-TOP

A1 = [5, 7, 3]<-TOP

B1 = [6, 4]<-TOP

Now first print B1 from top to bottom then A1 from top to bottom.
*/
import java.util.*;
public class Playing_with_cardsI_In_stack {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		Stack<Integer> s1=new Stack<Integer>();
		
		Stack<Integer> b= new Stack<Integer>();
		
		for(int i=0;i<n;i++)
			s1.push(sc.nextInt());
		for(int i=0;i<q;i++){
			int p=getPrime(i+1);
			Stack<Integer> a= new Stack<Integer>();
			while(!s1.isEmpty()){
				
				int ele=s1.pop();
				if(ele%p==0){
					b.push(ele);
					// System.out.println(ele+" "+i);
				}
					
				else
					a.push(ele);
			}
			while(!b.isEmpty())
				System.out.println(b.pop());
			s1=a;
			// while(!a.isEmpty())
			// 	s1.push(a.pop());
		}
		// s1=a;
		while(!s1.isEmpty())
			System.out.println(s1.pop());
    }

	public static int getPrime(int n){
		for(int i=2;i<Integer.MAX_VALUE;i++){
	        int count=0;
	        for(int j=1;j*j<=i;j++){
	            if(i%j==0)
	                count++;
	        }
	        if(count==1){
	            n--;
	        }
	        if(n==0)
	            return i;
	        
	    }
		return 0;
	}
}


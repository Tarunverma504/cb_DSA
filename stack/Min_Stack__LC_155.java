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
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
Accepted
893,324
Submissions
1,809,077
*/
import java.util.*;
public class Min_Stack__LC_155 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/min-stack/
        */
    }
    static class MinStack {

    /** initialize your data structure here. */
    static class Node{
        int val;
        int min;
        Node next=null;
        Node(int val,int min){
            this.val=val;
            this.min = min;
        }
    }
    Node head;
    static int min;
    public MinStack() {
        this.min=Integer.MAX_VALUE;
        head=null;
    }
    
    public void push(int val) {
        if(head==null){
            head= new Node(val,val);
        }
        else{
            Node temp = new Node(val, Math.min(head.min, val));
            temp.next=head;
            head=temp;
        }
    }
    
    public void pop() {
        head= head.next;
    }
    
    public int top() {
        if(head==null)
            return -1;
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
    }
}

}

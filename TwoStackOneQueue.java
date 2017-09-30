package javaLeetCode;

import java.util.Stack;
public class TwoStackOneQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    private void move() {
        while (!stack1.empty()) {
		    int i  = stack1.pop();
		    stack2.push(i);
	    }
    }
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int delete;
    	if (!stack2.empty()) {
        	delete = stack2.pop();
        }
        else {
        	move();
            delete = stack2.pop();
        }
        return delete;
    }
}

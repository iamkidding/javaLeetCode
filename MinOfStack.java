package javaLeetCode;

import java.util.Stack;

public class MinOfStack {
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    //    private int min;

    public void push(int node){
        if (minStack.isEmpty()) {
            min.push(node);
        }
        if (min.peek() >= node){
            min.push(node);
        }
        minStack.push(node);
    }

    public void pop(){
        int popedInt = minStack.pop();
        if (popedInt == min.peek()) min.pop();
    }

    public int top(){
        return minStack.peek();
    }

    public int min(){
        return min.peek();
    }
}

package javaLeetCode;

import java.util.Stack;

public class MinOfStack {
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> min = new Stack<>(); //辅助栈用于保存最小值，按照从小到大排列，即先进栈的大于后进栈的

    public void push(int node){
        if (minStack.isEmpty()) {
            min.push(node);  // 栈开始是空的的话，直接将压入的int压入辅助栈
        }
        // 等于号是为了保存多个最小值，应对原栈存在最小值的情况
        // 这样使用原栈pop()删除的是最小值的话，辅助栈中同样保存其他几个对应最小值，不会改变min()的值
        if (min.peek() >= node){
            min.push(node); // 非空的时候进行比较
        }
        minStack.push(node);
    }

    public void pop(){
        int popedInt = minStack.pop();
        if (popedInt == min.peek()) min.pop(); //如果删除的是栈内最小值，将辅助栈中的也删除
    }

    public int top(){
        return minStack.peek();
    }

    public int min(){
        return min.peek();
    }
}

package com.devil.basic.structure.stack;

import java.util.Stack;

/**
 * 栈测试   用两个栈实现队列
 *
 * @author Devil
 * @date Created in 2021/7/8 18:55
 */
public class StackTest {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        StackTest solution = new StackTest();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    public void push(int node) {
        while (!stack2.empty()) {
            Integer popNode = stack2.pop();
            stack1.push(popNode);
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            Integer popNode = stack1.pop();
            stack2.push(popNode);
        }
        if (!stack2.empty()) {
            return stack2.pop();
        }
        return 0;
    }

}

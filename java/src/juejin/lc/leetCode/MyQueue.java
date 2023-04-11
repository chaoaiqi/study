package juejin.lc.leetCode;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> baseStack;

    /**
     * Initialize your data structure here.
     */
    private MyQueue() {
        stack = new Stack<>();
        baseStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    private void push(int x) {
        System.out.println(stack.toString());
        while (!stack.empty()) {
            baseStack.push(stack.pop());
        }
        baseStack.push(x);
        while (!baseStack.empty()) {
            stack.push(baseStack.pop());
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    private int pop() {
        Integer num = stack.pop();
        return null == num ? -1 : num;
    }

    /**
     * Get the front element.
     */
    private int peek() {
        Integer num = stack.peek();
        return null == num ? -1 : num;
    }

    /**
     * Returns whether the queue is empty.
     */
    private boolean empty() {
        return stack.empty() && baseStack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int param_2 = myQueue.pop();
        System.out.println("param_2 = " + param_2);
        int param_3 = myQueue.peek();
        System.out.println("param_3 = " + param_3);
        boolean param_4 = myQueue.empty();
        System.out.println("param_4 = " + param_4);
    }
}

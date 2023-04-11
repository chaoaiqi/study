package juejin.lc.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class MyStack {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    private MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    private void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            --size;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    private int pop() {
        Integer num = queue.poll();
        return null == num ? -1 : num;
    }

    /**
     * Get the top element.
     */
    private int top() {
        Integer num = queue.peek();
        return null == num ? -1 : num;
    }

    /**
     * Returns whether the stack is empty.
     */
    private boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int param_2 = myStack.pop();
        System.out.println("param_2 = " + param_2);
        int param_3 = myStack.top();
        System.out.println("param_3 = " + param_3);
        boolean param_4 = myStack.empty();
        System.out.println("param_4 = " + param_4);
    }
}

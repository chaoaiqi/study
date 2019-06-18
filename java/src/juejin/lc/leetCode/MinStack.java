package juejin.lc.leetCode;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author liuchao
 * @date 2019/6/10
 */
public class MinStack {
    private Stack<Integer> stack;

    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int min = stack.peek();
            stack.push(x);
            if (min < x) {
                stack.push(min);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        System.out.println("size=" + stack.size());
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
//        while (!minStack.stack.isEmpty()){
//            System.out.println("" + minStack.stack.pop());
//        }
//        System.out.println("----------------------");
//        System.out.println("length= " + minStack.stack.size());
        int min = minStack.getMin();
        System.out.println("最小值：" +  min);
        minStack.pop();
        int top = minStack.top();
        System.out.println("top:" + top);
        int newMin = minStack.getMin();
        System.out.println("newMin:" + newMin);
    }
}

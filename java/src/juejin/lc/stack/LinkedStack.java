package juejin.lc.stack;

import juejin.lc.linkedList.Node;

/**
 * 1.基于链表实现的链式栈
 * 2.栈中元素类型为int
 *
 * @author mic
 */
public class LinkedStack {
    /**
     * 链表
     */
    private Node head;

    /**
     * 入栈
     *
     * @param num
     */
    public void push(int num) {
        Node node = new Node(num, null);
        if (head != null) {
            // 倒序插入，为出栈做准备
            node.next = head;
        }
        head = node;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (head == null)
            return -1;// -1表示栈空
        int res = head.data;
        head = head.next;
        return res;
    }

    public void printAll() {
        Node printNode = head;
        while (printNode != null) {
            System.out.println("-----");
            System.out.println("| " + printNode.data + " |");
            printNode = printNode.next;
        }
        System.out.println("-----");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 1; i < 6; i++) {
            //入栈
            linkedStack.push(i);
        }
//		linkedStack.printAll();
        //出栈
        linkedStack.pop();
        linkedStack.printAll();
    }
}

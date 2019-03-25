package juejin.lc.queue;

import juejin.lc.linkedList.Node;

/**
 * 1.基于链表实现的链式队列
 * 2.队列中元素类型为int
 *
 * @author mic
 */
public class LinkedQueue {

    /**
     * 队列队头下标
     */
    private Node head;
    /**
     * 队列的队尾下标
     */
    private Node tail;

    /**
     * 入队
     *
     * @param num
     * @return
     */
    public void enqueue(int num) {
        if (tail == null) {
            Node node = new Node(num, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(num, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public int dequeue() {
        if (head == null) return -1;//-1表示队空
        int res = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return res;
    }

    public void printAll() {
        Node node = head;
        while (node != null) {
            System.out.println("-----");
            System.out.println("| " + node.data + " |");
            node = node.next;
        }
        System.out.println("-----");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 1; i < 6; i++) {
            //入队
            linkedQueue.enqueue(i);
        }
        linkedQueue.printAll();
        //出队
        int num = linkedQueue.dequeue();
        System.out.println("出队：" + num);
        linkedQueue.printAll();
    }

}

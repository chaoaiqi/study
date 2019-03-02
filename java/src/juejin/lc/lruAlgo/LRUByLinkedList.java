package juejin.lc.lruAlgo;

import juejin.lc.linkedList.Node;

public class LRUByLinkedList {
    /**
     * 头结点
     */
    private Node head;

    /**
     * 链表长度
     */
    private int size;
    /**
     * 链表容量
     */
    private int count;

    /**
     * 有参构造函数
     *
     * @param capacity 数组容量大小
     */
    private LRUByLinkedList(int capacity) {
        head = null;
        size = capacity;
        count = 0;
    }

    /**
     * insert
     *
     * @param data 数据
     */
    private void insert(int data) {
        Node preNode = findNode(data);
        if (null != preNode) {
            delete(preNode);
        } else {
            if (count >= size) {//链表满
                deleteToTail();
            }
        }
        insertToHead(data);
    }

    /**
     * 删除链表尾部元素
     */
    private void deleteToTail() {
        Node node = head;
        Node curNode = null;
        while (null != node.next) {
            curNode = node;
            node = node.next;
        }
        if (null != curNode) {
            System.out.println("链表已满，删除尾部元素：" + curNode.next.data);
            curNode.next = null;
        }
        --count;
    }

    /**
     * 链表头部插入元素
     *
     * @param data
     */
    private void insertToHead(int data) {
        Node node = new Node(data, null);
        if (null == head) {
            head = node;
        } else {
            node.next = head;
        }
        head = node;
        ++count;
    }

    /**
     * 删除指定元素
     *
     * @param preNode 指定元素的前一个节点
     */
    private void delete(Node preNode) {
        System.out.println("删除指定元素：" + preNode.next.data);
        preNode.next = preNode.next.next;
        --count;
    }

    /**
     * 查询该元素是否存在
     *
     * @param data 目标
     * @return 返回该元素的前一个节点
     */
    private Node findNode(int data) {
        Node node = head;
        while (null != node && null != node.next) {
            Node nextNode = node.next;
            if (data == nextNode.data) {
                return node;
            }
            node = nextNode;
        }
        return null;
    }

    private void printAll() {
        Node node = head;
        while (null != node) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 10;
        LRUByLinkedList lruByLinkedList = new LRUByLinkedList(capacity);
        for (int i = 0; i < 10; i++) {
            lruByLinkedList.insert(i);
        }
        lruByLinkedList.printAll();
        lruByLinkedList.insert(10);
        lruByLinkedList.printAll();
        lruByLinkedList.insert(8);
        lruByLinkedList.printAll();
    }
}

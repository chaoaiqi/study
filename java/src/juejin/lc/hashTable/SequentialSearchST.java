package juejin.lc.hashTable;

import java.util.LinkedList;

/**
 * 基于无序链表的顺序查找
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {

    /**
     * 链表头结点
     */
    private Node head;

    SequentialSearchST() {
    }

    /**
     * get
     *
     * @param key 建
     * @return 值
     */
    Value get(Key key) {
        if (null == key) return null;
        Node node = head;
        while (null != node) {
            if (key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * put方法
     *
     * @param key   key
     * @param value value
     */
    void put(Key key, Value value) {
        if (null == key) return;
        Node node = head;
        while (null != node) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        head = new Node(key, value, head);
    }

    /**
     * keys()
     *
     * @return 返回值
     */
    Iterable<Key> keys() {
        LinkedList<Key> linkedList = new LinkedList<>();
        Node node = head;
        while (null != node) {
            linkedList.add(node.key);
            node = node.next;
        }
        return linkedList;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<Integer,String> sequentialSearchST = new SequentialSearchST<>();
        for (int i = 0; i < 6; i++) {
            sequentialSearchST.put(i,"value = " + i);
        }
        for (Integer key:sequentialSearchST.keys()){
            String value = sequentialSearchST.get(key);
            System.out.println("{ key = " + key + ", " + value + " }");
        }
    }
}

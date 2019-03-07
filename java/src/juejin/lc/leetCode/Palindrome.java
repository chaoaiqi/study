package juejin.lc.leetCode;

import juejin.lc.linkedList.Node;
import juejin.lc.linkedList.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 判断单链表回文的三种方法
 */
public class Palindrome {

    /**
     * 基于数组
     *
     * @param node 链表
     * @return 返回值
     */
    private boolean isPalindromeByArray(Node node) {
        if (null == node || null == node.next) return true;
        List<Integer> nodeList = new ArrayList<>();
        Node fast = node;
        Node slow = node;
        nodeList.add(0, slow.data);
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            nodeList.add(0, slow.data);
        }
        Node curNode = slow;
        if (null != fast.next) {
            curNode = slow.next;
        }
        int index = 0;
        while (null != curNode) {
            if (curNode.data != nodeList.get(index)) {
                return false;
            }
            curNode = curNode.next;
            ++index;
        }
        return true;
    }

    /**
     * 基于栈
     *
     * @param node 链表
     * @return 返回值
     */
    private boolean isPalindromeByStack(Node node) {
        if (null == node || null == node.next) return true;
        Stack<Integer> stack = new Stack<>();
        Node fast = node;
        Node slow = node;
        stack.push(slow.data);
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.data);
        }
        if (null != fast.next) {
            slow = slow.next;
        }
        Node curNode = slow;
        while (null != curNode) {
            if (curNode.data != stack.pop()) {
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }

    /**
     * 原地链表法
     *
     * @param node
     * @return
     */
    private boolean isPalindromeAuto(Node node) {
        if (null == node || null == node.next) return true;
        Node fast = node;
        Node slow = node;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node preNode = slow;
        Node firstNode = slow.next;
        Node curNode = slow.next.next;
        firstNode.next = null;
        while (null != curNode) {
            Node nextNode = curNode.next;
            curNode.next = preNode.next;
            preNode.next = curNode;
            curNode = nextNode;
        }
        slow = node;
        fast = preNode.next;
        while (null != fast) {
            if (fast.data != slow.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertTail(1);
        singlyLinkedList.insertTail(2);
        singlyLinkedList.insertTail(3);
//        singlyLinkedList.insertTail(4);
        singlyLinkedList.insertTail(2);
        singlyLinkedList.insertTail(1);
        singlyLinkedList.printAll();
        boolean isPalindromeByArray = palindrome.isPalindromeByArray(singlyLinkedList.head);
        System.out.println(isPalindromeByArray);
        boolean isPalindromeByStack = palindrome.isPalindromeByStack(singlyLinkedList.head);
        System.out.println(isPalindromeByStack);
        boolean isPalindromeAuto = palindrome.isPalindromeAuto(singlyLinkedList.head);
        System.out.println(isPalindromeAuto);
    }
}

package juejin.lc.linkedList;

/**
 * 1.单链表反转
 * 2.检测环
 * 3.求链表的中间结点
 * 4.删除倒数第k个节点
 * 5.两个有序的链表合并
 *
 * @author mic
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     *
     * @param node
     */
    public Node reverse(Node node) {
        Node resNode = null;
        Node prevNode = null;
        Node curNode = node;
        while (curNode != null) {
            Node nextNode = curNode.next;
            if (nextNode == null) {
                resNode = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return resNode;
    }

    /**
     * 检测环
     *
     * @param node
     * @return
     */
    public boolean checkCircle(Node node) {
        if (node == null)
            return false;
        // 快慢指针法
        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 求链表的中间结点
     *
     * @param node
     * @return
     */
    public Node findMiddleByNode(Node node) {
        if (node == null)
            return null;
        // 快慢指针法
        Node fast = node.next;
        Node slow = node;
        // 快指针走完一圈，慢指针半圈
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除倒数第k个节点
     *
     * @param node
     * @param k
     * @return
     */
    public Node deleteLastKByNode(Node node, int k) {
        // 快慢指针法
        Node fast = node;
        // 计数
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }
        if (fast == null)
            return node;
        Node slow = node;
        Node prevNode = null;
        while (fast.next != null) {
            fast = fast.next;
            prevNode = slow;
            slow = slow.next;
        }
        if (prevNode == null) {
            node = node.next;
        } else {
            // 删除
            prevNode.next = prevNode.next.next;
        }
        return node;
    }

    /**
     * 两个有序的链表合并
     *
     * @param pNode
     * @param qNode
     * @return
     */
    public Node mergeNode(Node pNode, Node qNode) {
        if (pNode == null)
            return qNode;
        if (qNode == null)
            return pNode;
        Node p = pNode;
        Node q = qNode;
        Node resNode = null;
        if (p.data < q.data) {
            resNode = p;
            p = p.next;
        } else {
            resNode = q;
            q = q.next;
        }
        Node node = resNode;
        while (p != null && q != null) {
            if (p.data < q.data) {
                node.next = p;
                p = p.next;
            } else {
                node.next = q;
                q = q.next;
            }
            node = node.next;
        }
        if (p != null) {
            node.next = p;
        } else {
            node.next = q;
        }
        return resNode;
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        Node pNode = new Node(1, null);
        Node pNode3 = new Node(3, null);
        Node pNode5 = new Node(5, null);
        pNode.next = pNode3;
        pNode3.next = pNode5;
        linkedListAlgo.print(pNode);
        Node qNode = new Node(2, null);
        Node qNode4 = new Node(4, null);
        Node qNode6 = new Node(6, null);
        qNode.next = qNode4;
        qNode4.next = qNode6;
        linkedListAlgo.print(qNode);
        Node mergeNode = linkedListAlgo.mergeNode(pNode, qNode);
        linkedListAlgo.print(mergeNode);
//		Node node = new Node(0, null);
//		Node node1 = new Node(1, null);
//		Node node2 = new Node(2, null);
//		Node node3 = new Node(3, null);
//		Node node4 = new Node(4, null);
//		node.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		linkedListAlgo.print(node);
//		Node kNode = linkedListAlgo.deleteLastKByNode(node, 4);
//		linkedListAlgo.print(kNode);
//		Node midNode = linkedListAlgo.findMiddleByNode(node);
//		linkedListAlgo.print(midNode);
//		boolean checkCircle = linkedListAlgo.checkCircle(node);
//		System.out.println("环检测结果:" + checkCircle);
//		Node newNode = linkedListAlgo.reverse(node);
//		linkedListAlgo.print(newNode);
    }
}

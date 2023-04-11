package juejin.lc.leetCode;

/**
 * 单链表反转
 */
public class ReverseList {
    private ListNode solution(ListNode head) {
        ListNode resNode = null;
        ListNode prevNode = null;
        ListNode curNode = head;
        while (null != curNode) {
            ListNode nextNode = curNode.next;
            if (null == nextNode) {
                resNode = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return resNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode createNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    private void print(ListNode listNode) {
        while (null != listNode) {
            int val = listNode.val;
            System.out.print(val);
            if (null != listNode.next) {
                System.out.print("->");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.createNode();
        reverseList.print(head);
        ListNode resNode = reverseList.solution(head);
        reverseList.print(resNode);
    }
}

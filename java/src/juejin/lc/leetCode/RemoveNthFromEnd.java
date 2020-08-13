package juejin.lc.leetCode;

public class RemoveNthFromEnd {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution(ListNode head, int n) {
        // 快慢指针法
        ListNode fast = head;
        int i = 1;
        while (i < n && null != fast) {
            fast = fast.next;
            ++i;
        }
        if (null == fast) {
            return head;
        }
        ListNode slow = head;
        ListNode prevNode = null;
        while (null != fast.next) {
            fast = fast.next;
            prevNode = slow;
            slow = slow.next;
        }
        if (null == prevNode) {
            head = head.next;
        } else {
            prevNode.next = prevNode.next.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

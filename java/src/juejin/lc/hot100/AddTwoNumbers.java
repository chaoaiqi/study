package juejin.lc.hot100;

public class AddTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode curr = resNode;
        int index = 0;
        while (null != l1 || null != l2) {
            int x = null != l1 ? l1.val : 0;
            int y = null != l2 ? l2.val : 0;
            int sum = x + y + index;
            index = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (index > 0) {
            curr.next = new ListNode(index);
        }
        return resNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

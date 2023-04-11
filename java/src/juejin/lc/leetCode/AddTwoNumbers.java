package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 单位 数字。
 * <p>
 * 如果，我们将这两个数起来相加起来，则会返回出一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * @author liuchao
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (null != p) ? p.val : 0;
            int y = (null != q) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (null != p)
                p = p.next;
            if (null != q)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public void initListNode() {
        ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        List<Integer> list = new ArrayList<Integer>();
        boolean sign = false;
        while (null != l1 || null != l2) {
            int sum = 0;
            if (null == l1) {
                sum = l2.val;
            } else if (null == l2) {
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
            }
            int val = sum >= 10 ? sum - 10 : sum;
            if (sign) {
                sign = false;
                if (val + 1 >= 10) {
                    sign = true;
                }
                val = val + 1 >= 10 ? val + 1 - 10 : val + 1;
            }
            if (sum >= 10) {
                sign = true;
            }
            list.add(val);
            if (null != l1)
                l1 = l1.next;
            if (null != l2)
                l2 = l2.next;
        }
        if (sign) {
            list.add(1);
        }
        ListNode listNode = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
            ListNode node = new ListNode(list.get(i));
            if (null == listNode) {
                listNode = node;
            } else {
                node.next = listNode;
                listNode = node;
            }
        }
        while (null != listNode) {
            System.out.print(listNode.val);
            if (listNode.next != null)
                System.out.print("-");
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        new AddTwoNumbers().initListNode();
    }

    public class ListNode {
        public int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            this.val = x;
        }
    }
}

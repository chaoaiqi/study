package juejin.lc.leetCode;

/**
 * 合并两个有序链表
 * 1 -> 2 -> 4   1 -> 3 -> 4
 * 1 -> 1 -> 2 -> 3 -> 4 -> 4
 *
 * @author liuchao
 * @date 2019/5/23
 */
public class MergeTwoLists {
    /**
     * 合并两个有序链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 返回合并后的链表
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        //边界条件判断
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode lNode = l1;
        ListNode rNode = l2;
        ListNode node = null;
        if (lNode.val > rNode.val) {
            node = new ListNode(rNode.val);
            rNode = rNode.next;
        } else {
            node = new ListNode(lNode.val);
            lNode = lNode.next;
        }
        ListNode temp = node;
        while (null != lNode && null != rNode) {
            if (lNode.val > rNode.val) {
                temp.next = rNode;
                rNode = rNode.next;
            } else {
                temp.next = lNode;
                lNode = lNode.next;
            }
            temp = temp.next;
        }
        if (null != lNode) {
            temp.next = lNode;
        }
        if (null != rNode) {
            temp.next = rNode;
        }
        return node;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = mergeTwoLists.solution(l1, l2);
        while (null != res) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

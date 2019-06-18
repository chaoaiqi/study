package juejin.lc.leetCode;

/**
 * 相交链表
 *
 * @author liuchao
 * @date 2019/6/18
 */
public class GetIntersectionNode {
    public ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = null == pA ? headB : pA.next;
            pB = null == pB ? headA : pB.next;
        }
        return pA;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        //4  1  8  4  5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        //5 0 1 8 4 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode resNode = getIntersectionNode.solution(headA, headB);
        System.out.println(null == resNode);

    }
}

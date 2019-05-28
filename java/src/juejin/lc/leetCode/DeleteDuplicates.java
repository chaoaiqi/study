package juejin.lc.leetCode;

/**
 * 删除排序链表中的重复元素
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class DeleteDuplicates {
    /**
     * 输入: 1->1->2
     * 输出: 1->2
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * @param head 链表
     * @return 返回新链表
     */
    public ListNode solution(ListNode head) {
        ListNode p = head;
        while (null != p && null != p.next) {
            if (p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode res = deleteDuplicates.solution(head);
        while (null != res){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

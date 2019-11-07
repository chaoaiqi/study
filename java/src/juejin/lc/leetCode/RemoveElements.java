package juejin.lc.leetCode;

public class RemoveElements {
    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     *  示例:
     *
     *  输入: 1->2->6->3->4->5->6, val = 6
     *  输出: 1->2->3->4->5
     * @param head 单链表
     * @param val 给定值
     * @return 输出链表
     */
    private ListNode solution(ListNode head, int val) {
        //删除头结点时另做考虑（由于头结点没有前一个结点）
        while (null != head && head.val == val){
            head = head.next;
        }
        if (null == head){
            return null;
        }
        ListNode node =head;
        while (null != node.next) {
            if (node.next.val == val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
    private ListNode solution2(ListNode head, int val){
        //创建一个虚拟头结点
        //随机传任意一个不等于val的值作为虚拟头结点
        ListNode dummyNode = new ListNode(val - 1);
        dummyNode.next = head;
        ListNode node = dummyNode;
        while (null != node.next){
            if (node.next.val == val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return dummyNode.next;
    }
    private ListNode solution3(ListNode head, int val){
        // 递归
        if (null == head){
            return null;
        }
        head.next = solution3(head.next,val);
        if (head.val == val){
            return head.next;
        }
        return head;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private ListNode createNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        return node1;
    }
    private void print(ListNode listNode) {
        while (null != listNode){
            int val = listNode.val;
            System.out.print(val);
            if (null != listNode.next){
                System.out.print("->");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode head = removeElements.createNode();
        removeElements.print(head);
        int val = 6;
        ListNode result = removeElements.solution(head,val);
        ListNode result2 = removeElements.solution2(head,val);
        ListNode result3 = removeElements.solution3(head,val);
        removeElements.print(result);
        removeElements.print(result2);
        removeElements.print(result3);
    }
}

package juejin.lc.leetCode;

/**
 * 删除链表中的节点
 */
public class DeleteNode {
    private ListNode head;
    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     * 说明:
     *
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。

     * @param node 节点
     */
    private void solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 常规删除链表指定节点，与题目无关
     * @param node 节点
     */
    private void solution1(ListNode node) {
        ListNode headNode = head;
        if (headNode.val == node.val){
            headNode = headNode.next;
        }
        while (null != headNode.next && null != headNode.next.next){
            if (headNode.next.val == node.val){
                headNode.next = headNode.next.next;
            }else {
                headNode = headNode.next;
            }
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private ListNode createHead(){
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
    private ListNode createNode(){
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node3.next = node4;
        return node3;
    }
    private void print() {
        ListNode listNode = head;
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
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.head = deleteNode.createHead();
        deleteNode.print();
        ListNode node = deleteNode.createNode();
        deleteNode.solution(node);
        deleteNode.print();
    }
}

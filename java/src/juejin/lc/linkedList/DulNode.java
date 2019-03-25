package juejin.lc.linkedList;

/**
 * 双向链表类
 */
public class DulNode {
    /**
     * 数据
     */
    public int data;
    /**
     * 前驱节点
     */
    public DulNode prev;
    /**
     * 后继节点
     */
    public DulNode next;

    private DulNode() {
    }

    /**
     * 有参构造方法
     *
     * @param data 数据
     */
    public DulNode(int data) {
        this.data = data;
    }
}

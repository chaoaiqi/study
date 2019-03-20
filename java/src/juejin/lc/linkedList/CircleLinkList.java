package juejin.lc.linkedList;

/**
 * 循环链表
 */
public class CircleLinkList {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node tail;
    /**
     * 数据数量
     */
    private int count;

    /**
     * 无参构造方法
     */
    private CircleLinkList() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * 插入头部
     *
     * @param data 数据
     */
    private void insertHead(int data) {
        Node node = new Node(data, null);
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        ++count;
    }

    /**
     * 插入指定位置
     *
     * @param index 索引
     * @param data  数据
     */
    private void insertByIndex(int index, int data) {
        if (index > count) {
            insertTail(data);
        } else {
            Node resNode = findByIndex(index);
            if (null != resNode) {
                System.out.println("返回节点的值:" + resNode.data);
                resNode.next = new Node(data, resNode.next);
                ++count;
            }
        }
    }

    /**
     * 插入尾部
     *
     * @param data 数据
     */
    private void insertTail(int data) {
        Node node = new Node(data, null);
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.next = head;
            head = node;
        }
        ++count;
    }

    /**
     * 删除
     *
     * @param index 索引
     */
    private void delete(int index) {
        if (index > count) return;
        if (index == 0) {
            Node node = head;
            head = head.next;
            node.next = null;
            tail.next = head;
        } else if (index == count - 1) {
            Node resNode = findByIndex(index);
            if (null != resNode) {
                Node node = tail;
                tail = resNode;
                node.next = null;
                tail.next = head;
            }
        } else {
            Node resNode = findByIndex(index - 1);//查找该节点的前一个节点
            if (null != resNode) {
                System.out.println("返回节点的值:" + resNode.data);
                resNode.next = resNode.next.next;
            }
        }
        --count;
    }

    /**
     * 查找
     *
     * @param index 索引
     * @return 返回值
     */
    private Node findByIndex(int index) {
        if (index > count) return null;
        Node node = head;
        int num = 0;
        while (num < index) {
            node = node.next;
            ++num;
        }
        return node;
    }

    private void printAll() {
        Node p = head;
        int flag = p.data;//跳出标识
        while (null != p) {
            System.out.print(p.data + " ");
            p = p.next;
            if (null == p || p.data == flag) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircleLinkList circleLinkList = new CircleLinkList();
        circleLinkList.insertHead(3);
        circleLinkList.insertHead(2);
        circleLinkList.insertHead(1);
        circleLinkList.insertTail(5);
        circleLinkList.insertTail(6);
        circleLinkList.insertTail(7);
        circleLinkList.insertTail(8);
        circleLinkList.insertByIndex(3,4);
        circleLinkList.printAll();
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        boolean result = linkedListAlgo.checkCircle(circleLinkList.head);
        System.out.println("检测环返回值：" + result);
        circleLinkList.delete(1);
        circleLinkList.printAll();
    }
}

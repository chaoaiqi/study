package juejin.lc.linkedList;

/**
 * 双向链表
 */
public class DulLinkList {
    /**
     * 声明一个头结点
     */
    private DulNode head;
    /**
     * 声明一个尾部节点
     */
    private DulNode tail;

    /**
     * 链表数量
     */
    private int count;

    private DulLinkList() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * 添加到链表头部
     *
     * @param data
     */
    private void insertToHead(int data) {
        DulNode dulNode = new DulNode(data);
        if (count == 0) {
            head = dulNode;
            tail = dulNode;
        } else {
            DulNode prev = head;
            prev.prev = dulNode;
            dulNode.next = head;
            head = dulNode;
        }
        ++count;
    }

    /**
     * 添加到链表尾部
     *
     * @param data
     */
    private void insertToTail(int data) {
        DulNode dulNode = new DulNode(data);
        if (count == 0) {
            head = dulNode;
            tail = dulNode;
        } else {
            DulNode next = tail;
            dulNode.prev = next;
            next.next = dulNode;
            tail = dulNode;
        }
        ++count;
    }

    /**
     * 插入指定位置的数据
     *
     * @param index 索引
     * @param data  数据
     */
    private void insertByIndex(int index, int data) {
        if (index > count) {//放入链表尾部
            insertToTail(data);
        } else {
            DulNode resNode = selectByIndex(index);
            if (null != resNode) {
                System.out.println("根据index索引所得返回值为：" + resNode.data);
                DulNode dulNode = new DulNode(data);
                DulNode prev = resNode.prev;
                prev.next = dulNode;
                dulNode.prev = prev;
                dulNode.next = resNode;
                resNode.prev = dulNode;
            }
        }
        ++count;
    }

    /**
     * 删除链表头部
     * @return 返回值
     */
    private DulNode deleteHead() {
        DulNode p = head;
        if (count > 0) {
            head = head.next;
            head.prev = null;
            --count;
        }
        return p;
    }

    /**
     * 删除链表尾部
     * @return 返回值
     */
    private DulNode deleteTail() {
        DulNode q = tail;
        if (count > 0) {
            tail = tail.prev;
            tail.next = null;
            --count;
        }
        return q;
    }

    /**
     * 删除指定位置的数据
     *
     * @param index 索引
     */
    private void deleteByIndex(int index) {
        if (index > count)
            return;
        //删除这边加了个小技巧，如果是链表头部或者尾部，直接删除，中间值开始查找
        if (index == 0) {
            deleteHead();
        } else if (index == count - 1) {
            deleteTail();
        } else {
            DulNode resNode = selectByIndex(index);
            if (null != resNode) {
                System.out.println("要删除的元素为：" + resNode.data);
                DulNode prev = resNode.prev;
                DulNode next = resNode.next;
                prev.next = next;
                next.prev = prev;
                resNode.prev = null;
                resNode.next = null;
            }
            --count;
        }
    }

    /**
     * 根据指定索引获取节点
     *
     * @param index 索引
     * @return 返回值
     */
    private DulNode selectByIndex(int index) {
        if (index > count) return null;
        int num = 0;
        DulNode dulNode = head;
        while (num < index) {
            dulNode = dulNode.next;
            ++num;
        }
        return dulNode;
    }

    /**
     * 根据指定节点获取下标
     *
     * @param data 数据
     * @return 返回值
     */
    private int indexOf(int data) {
        int num = 0;
        DulNode dulNode = head;
        while (num < count && null != dulNode) {
            if (data == dulNode.data) {
                return num;
            }
            dulNode = dulNode.next;
            ++num;
        }
        return -1;
    }

    private void printAll() {
        DulNode dulNode = head;
        while (null != dulNode) {
            System.out.print(dulNode.data + " ");
            dulNode = dulNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DulLinkList dulLinkList = new DulLinkList();
        dulLinkList.insertToHead(3);
        dulLinkList.insertToHead(2);
        dulLinkList.insertToHead(1);
        dulLinkList.insertToTail(5);
        dulLinkList.insertToTail(6);
        dulLinkList.insertToTail(7);
        dulLinkList.insertToTail(8);
        dulLinkList.insertToTail(9);
        dulLinkList.printAll();
        System.out.println("删除头部,并返回");
        DulNode resHead = dulLinkList.deleteHead();
        System.out.println("返回值：" + resHead.data);
        dulLinkList.insertByIndex(3, 4);
        dulLinkList.printAll();
        System.out.println("删除尾部,并返回");
        DulNode resTail = dulLinkList.deleteTail();
        System.out.println("返回值：" + resTail.data);
        dulLinkList.printAll();
        int data = 5;
        int res = dulLinkList.indexOf(data);
        System.out.println("数据" + data + "的下标 " + (res != -1 ? res : "不存在"));
        int delData = 5;
        dulLinkList.deleteByIndex(delData);
        dulLinkList.printAll();
    }
}

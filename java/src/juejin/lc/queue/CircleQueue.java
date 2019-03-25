package juejin.lc.queue;

public class CircleQueue {

    /**
     * 数组
     */
    private int[] arrays;
    /**
     * 数组大小
     */
    private int size;
    /**
     * 队列队头下标
     */
    private int head;
    /**
     * 队列队尾下标
     */
    private int tail;

    /**
     * 初始化数组，申请一个大小为capacity大小的内存空间
     *
     * @param capacity
     */
    public CircleQueue(int capacity) {
        arrays = new int[capacity];
        size = capacity;
        head = 0;
        tail = 0;
    }

    /**
     * 入队
     *
     * @param num
     * @return
     */
    public boolean enqueue(int num) {
        if ((tail + 1) % size == head)
            return false;
        arrays[tail] = num;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public int dequeue() {
        if (head == tail)
            return -1;// -1表示队空
        int ret = arrays[head];
        head = (head + 1) % size;
        return ret;
    }

    public void printAll() {
        if (size == 0)
            System.out.println("队空");
        for (int i = head; i % size != tail; ++i) {
            System.out.println(arrays[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        for (int i = 1; i < 6; i++) {
            // 入队
            circleQueue.enqueue(i);
        }
        circleQueue.printAll();
    }

}

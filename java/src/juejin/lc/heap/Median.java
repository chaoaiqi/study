package juejin.lc.heap;

/**
 * 求一组动态数据集合的中位数
 */
public class Median {

    /**
     * 大顶堆
     */
    private MaxHeap maxHeap;
    /**
     * 小顶堆
     */
    private MinHeap minHeap;

    /**
     * 数据数量
     */
    private int count;

    /**
     * 有参构造方法
     *
     * @param capacity 大小
     */
    public Median(int capacity) {
        maxHeap = new MaxHeap(capacity);
        minHeap = new MinHeap(capacity);
        count = 0;
    }

    /**
     * 插入
     *
     * @param data
     */
    private void insert(int data) {
        ++count;
        if (maxHeap.count == 0 && minHeap.count == 0) {
            maxHeap.insert(data);
            return;
        }
        int max = maxHeap.removeMax();
        if (data > max) {
            maxHeap.insert(max);
            maxHeap.insert(data);
        } else {
            maxHeap.insert(max);
            minHeap.insert(data);
        }
        int mid = count / 2;
        if (maxHeap.count > mid) {
            moveMaxMin(maxHeap, minHeap, maxHeap.count - mid);
        }
        if (minHeap.count > mid) {
            moveMinMax(maxHeap, minHeap, minHeap.count - mid);
        }
    }

    /**
     * 从大顶堆中向小顶堆堆中移动元素
     *
     * @param maxHeap 大
     * @param minHeap 小
     * @param index
     */
    private void moveMaxMin(MaxHeap maxHeap, MinHeap minHeap, int index) {
        for (int i = 0; i < index; i++) {
            int data = maxHeap.removeMax();
            minHeap.insert(data);
        }
    }

    /**
     * 从小顶堆中向大顶堆堆中移动元素
     *
     * @param maxHeap 大
     * @param minHeap 小
     * @param index
     */
    private void moveMinMax(MaxHeap maxHeap, MinHeap minHeap, int index) {
        for (int i = 0; i < index; i++) {
            int data = minHeap.removeMin();
            maxHeap.insert(data);
        }
    }

    public static void main(String[] args) {
        int capacity = 10;
        Median median = new Median(5);
        for (int i = 1; i < capacity; i++) {
            median.insert(i);
        }
        System.out.println("大顶堆:");
        median.maxHeap.printAll();
        System.out.println("小顶堆:");
        median.minHeap.printAll();
        int midNum = median.maxHeap.removeMax();
        System.out.println("中位数为:" + midNum);
    }
}

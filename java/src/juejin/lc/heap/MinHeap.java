package juejin.lc.heap;

/**
 * 大顶堆
 */
public class MinHeap {
    /**
     * 数组，从下标 1开始存储数据
     */
    public int[] arrays;
    /**
     * 数组大小
     */
    public int size;
    /**
     * 数组中存储数据数量
     */
    public int count;

    /**
     * 有参构造方法
     *
     * @param capacity 数组大小
     */
    public MinHeap(int capacity) {
        arrays = new int[++capacity];
        size = capacity;
        count = 0;
    }

    /**
     * 插入
     *
     * @param data 数据
     */
    public void insert(int data) {
        if (count >= size) return;
        arrays[++count] = data;
        int i = count;
        while (i / 2 > 0 && arrays[i] < arrays[i / 2]) {
            swap(arrays, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 移除堆顶元素
     */
    public int removeMin() {
        if (count == 0) return -1;
        int res = arrays[1];
        arrays[1] = arrays[count--];
        heapify(arrays, count, 1);
        return res;
    }

    /**
     * 自下向上堆化
     *
     * @param arrays 数组
     * @param count  数组数量
     * @param i      1
     */
    public void heapify(int[] arrays, int count, int i) {
        while (true) {
            int max = i;
            if (i * 2 <= count && arrays[i] > arrays[i * 2]) max = i * 2;
            if (i * 2 + 1 <= count && arrays[max] > arrays[i * 2 + 1]) max = i * 2 + 1;
            if (max == i) break;
            swap(arrays, i, max);
            i = max;
        }
    }

    /**
     * 交换
     */
    public void swap(int[] arrays, int p, int q) {
        int temp = arrays[p];
        arrays[p] = arrays[q];
        arrays[q] = temp;
    }

    /**
     * 类似一个层级遍历
     */
    public void printAll() {
        for (int i = 1; i < count + 1; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        for (int i = 10; i > 0; --i) {
            minHeap.insert(i);
        }
        System.out.println("小顶堆:");
        minHeap.printAll();
        int res = minHeap.removeMin();
        System.out.println("顶堆元素:" + res);
        System.out.println("删除堆顶元素后:");
        minHeap.printAll();
    }
}

package juejin.lc.lruAlgo;

import java.util.stream.IntStream;

/**
 * 基于数组实现
 */
public class LRUByArray {
    /**
     * 数组
     */
    private int arrays[];
    /**
     * 数组长度
     */
    private int size;
    /**
     * 数组中数据数量
     */
    private int count;

    /**
     * 有参构造函数
     *
     * @param capacity 数组容量大小
     */
    private LRUByArray(int capacity) {
        arrays = new int[capacity];
        size = capacity;
        count = 0;
    }

    /**
     * 插入
     *
     * @param data 数据
     */
    private void insert(int data) {
        int index = findValue(data);
        if (-1 != index) {
            delete(index);
        } else {
            if (count >= size) {//数组满
                deleteToTail();
            }
        }
        insertToHead(data);
    }

    /**
     * 在头部插入元素
     *
     * @param data 数据
     */
    private void insertToHead(int data) {
        if (count > 1) {
            for (int i = count - 1; i > -1; --i) {
                arrays[i + 1] = arrays[i];
            }
        }
        arrays[0] = data;
        ++count;
    }

    /**
     * 删除尾部元素
     */
    private void deleteToTail() {
        --count;//标记删除法，实际上数组还存有该元素
        System.out.println("删除尾部元素...");
    }

    /**
     * 删除数组中指定的元素
     *
     * @param index 元素下标
     */
    private void delete(int index) {
        //通过数据迁移的方式将该值删除
        for (int i = index + 1; i < count; i++) {
            arrays[i - 1] = arrays[i];
        }
        System.out.println("删除元素...");
        --count;
    }

    /**
     * 查找数组中有无该元素
     *
     * @param data 数据
     * @return 该数据所在数组的下标
     */
    private int findValue(int data) {
        for (int i = 0; i < count; i++) {
            if (arrays[i] == data) return i;
        }
        return -1;
    }

    private void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 10;
        LRUByArray lruByArray = new LRUByArray(capacity);
        IntStream.range(0, 10).forEach(lruByArray::insert);
        lruByArray.printAll();
        lruByArray.insert(10);
        lruByArray.printAll();
        lruByArray.insert(8);
        lruByArray.printAll();
    }
}

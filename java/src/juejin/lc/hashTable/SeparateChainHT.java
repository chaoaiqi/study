package juejin.lc.hashTable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拉链法
 */
public class SeparateChainHT<Key, Value> {
    /**
     * 初始化大小
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * 键值对总数
     */
    private int count;
    /**
     * 散列表大小
     */
    private int size;

    /**
     * 存放链表对象的数组
     */
    private SeparateChainHT<Key, Value>[] separateChainHTS;

    /**
     * 无参构造方法
     */
    private SeparateChainHT() {
        this(INIT_CAPACITY);
    }

    /**
     * 有参构造方法
     *
     * @param capacity 大小
     */
    private SeparateChainHT(int capacity) {
        //创建M条链表
        this.size = capacity;
        separateChainHTS = (SeparateChainHT<Key, Value>[]) new SeparateChainHT[capacity];
        for (int i = 0; i < size; i++) {
            separateChainHTS[i] = new SeparateChainHT<>();
        }
    }

    /**
     * hash
     *
     * @param key 键
     * @return 返回值
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    /**
     * put 方法
     *
     * @param key   键
     * @param value 值
     */
    private void put(Key key, Value value) {
        separateChainHTS[hash(key)].put(key, value);
    }

    /**
     * get 方法
     *
     * @param key 键
     * @return 值
     */
    private Value get(Key key) {
        return (Value) separateChainHTS[hash(key)].get(key);
    }

    /**
     * keys()
     * @return 遍历
     */
    private Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (Key key : separateChainHTS[i].keys())
                queue.add(key);
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainHT<Integer, String> separateChainHT = new SeparateChainHT<>();
        for (int i = 0; i < 10; i++) {
            separateChainHT.put(i, "value = " + i);
        }
        for (Integer key : separateChainHT.keys()) {
            String value = separateChainHT.get(key);
            System.out.println("{ key = " + key + "," + value + "}");
        }
    }
}

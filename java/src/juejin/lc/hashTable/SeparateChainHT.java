package juejin.lc.hashTable;

import java.util.LinkedList;

/**
 * 拉链法
 */
public class SeparateChainHT<Key, Value> {
    /**
     * 初始化大小
     */
    private static final int INIT_CAPACITY = 997;

    /**
     * 散列表大小
     */
    private int size;

    /**
     * 存放链表对象的数组
     */
    private SequentialSearchST<Key, Value>[] sequentialSearchSTS;

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
    @SuppressWarnings("unchecked")
	private SeparateChainHT(int capacity) {
        //创建M条链表
        this.size = capacity;
        sequentialSearchSTS = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[capacity];
        for (int i = 0; i < size; i++) {
            sequentialSearchSTS[i] = new SequentialSearchST<>();
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
        sequentialSearchSTS[hash(key)].put(key, value);
    }

    /**
     * get 方法
     *
     * @param key 键
     * @return 值
     */
    private Value get(Key key) {
        return sequentialSearchSTS[hash(key)].get(key);
    }

    /**
     * keys()
     * @return 遍历
     */
    private Iterable<Key> keys() {
        LinkedList<Key> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (Key key : sequentialSearchSTS[i].keys())
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

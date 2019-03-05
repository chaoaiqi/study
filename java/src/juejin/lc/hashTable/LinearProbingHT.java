package juejin.lc.hashTable;


import java.util.LinkedList;

/**
 * 线性探测法
 */
public class LinearProbingHT<Key, Value> {

    /**
     * 线性探测表的大小
     */
    private int size = 16;
    /**
     * 链表中键值对总数
     */
    private int count;
    /**
     * 键
     */
    private Key[] keys;
    /**
     * 值
     */
    private Value[] values;

    /**
     * 构造方法
     */
    @SuppressWarnings("unchecked")
    private LinearProbingHT() {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
    }

    /**
     * 有参构造方法
     *
     * @param capacity 大小
     */
    @SuppressWarnings("unchecked")
    private LinearProbingHT(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
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
     * resize
     *
     * @param capacity 大小
     */
    private void resize(int capacity) {
        System.out.println(size > capacity ? "缩容..." : "扩容...");
        LinearProbingHT<Key, Value> linearProbingHT;
        linearProbingHT = new LinearProbingHT<>(capacity);
        for (int i = 0; i < size; i++) {
            if (null != keys[i]) linearProbingHT.put(keys[i], values[i]);
        }
        keys = linearProbingHT.keys;
        values = linearProbingHT.values;
        size = linearProbingHT.size;
    }

    /**
     * put方法
     *
     * @param key   键
     * @param value 值
     */
    private void put(Key key, Value value) {
        if (count >= size / 2) resize(size * 2);//扩容
        int i;
        for (i = hash(key); null != keys[i]; i = (i + 1) % size) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        ++count;
    }

    /**
     * get方法
     *
     * @param key 键
     * @return 值
     */
    private Value get(Key key) {
        for (int i = hash(key); null != keys[i]; i = (i + 1) % size) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    /**
     * 删除
     *
     * @param key 键
     */
    private void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % size;
        }
        System.out.println("del-value:" + values[i]);
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % size;
        while (null != keys[i]) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            --count;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % size;
        }
        --count;
        if (count > 0 && count == size / 8) resize(size / 2);//缩容
    }

    private Iterable<Key> keys() {
        LinkedList<Key> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++)
            if (keys[i] != null) linkedList.add(keys[i]);
        return linkedList;
    }

    private boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        return get(key) != null;
    }

    public static void main(String[] args) {
        LinearProbingHT<Integer, String> linearProbingHT = new LinearProbingHT<>();
        for (int i = 0; i < 10; i++) {
            linearProbingHT.put(i, "value = " + i);
        }
//        int key = 6;
//        String value = linearProbingHT.get(key);
//        System.out.println("{ key = " + key + "," + value + "}");
//        int delKey = 8;
//        linearProbingHT.delete(delKey);
        for (Integer curKey : linearProbingHT.keys()) {
            String curValue = linearProbingHT.get(curKey);
            System.out.println("{ key = " + curKey + "," + curValue + "}");
        }
    }
}


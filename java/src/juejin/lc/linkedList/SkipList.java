package juejin.lc.linkedList;

import java.util.Random;

/**
 * 跳表
 */
public class SkipList {

    /**
     * 最大索引层级
     */
    private static final int MAX_LEVEL = 16;

    /**
     * 水平数
     */
    private int levelCount;

    /**
     * 头链表
     */
    private SNode head;

    /**
     * 随机数方法
     */
    private Random random;

    /**
     * 初始化
     */
    private SkipList() {
        levelCount = 1;
        head = new SNode();
        random = new Random();
    }

    /**
     * 插入
     *
     * @param data 数据
     */
    private void insert(int data) {
        int level = randomLevel();
        SNode sNode = new SNode();
        sNode.data = data;
        sNode.maxLevel = level;
        SNode[] forwards = new SNode[level];
        for (int i = 0; i < level; i++) {
            forwards[i] = head;
        }
        SNode p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (null != p.forwards[i] && p.forwards[i].data < data) {
                p = p.forwards[i];
            }
            forwards[i] = p;
        }
        for (int i = 0; i < level; i++) {
            sNode.forwards[i] = forwards[i].forwards[i];
            forwards[i].forwards[i] = sNode;
        }
        if (levelCount < level)
            levelCount = level;
    }

    /**
     * 删除
     *
     * @param data 数组
     */
    private void delete(int data) {
        SNode[] forwards = new SNode[levelCount];
        SNode sNode = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (null != sNode.forwards[i] && sNode.forwards[i].data < data) {
                sNode = sNode.forwards[i];
            }
            forwards[i] = sNode;
        }
        if (null != sNode.forwards[0] && sNode.forwards[0].data == data) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (null != forwards[i].forwards[i] && forwards[i].forwards[i].data == data)
                    forwards[i].forwards[i] = forwards[i].forwards[i].forwards[i];
            }
        }
    }

    /**
     * 根据value查找
     *
     * @param data 数据
     * @return SNode
     */
    private SNode findByValue(int data) {
        SNode sNode = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (sNode.forwards[i] != null && sNode.forwards[i].data < data) {
                sNode = sNode.forwards[i];
            }
        }
        if (null != sNode.forwards[0] && sNode.forwards[0].data == data) {
            return sNode.forwards[0];
        }
        return null;
    }

    /**
     * 随机最大level层级
     *
     * @return maxLevel
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                ++level;
            }
        }
//        System.out.println("randomLevel-level = " + level);
        return level;
    }

    private void printAll() {
        SNode sNode = head;
        while (sNode.forwards[0] != null) {
            System.out.println(sNode.forwards[0] + " ");
            sNode = sNode.forwards[0];
        }
        System.out.println();
    }

    public class SNode {
        private int data = -1;
        private SNode[] forwards = new SNode[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            return "{data:" + data + ",level:" + maxLevel + "}";
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 10; i++) {
            skipList.insert(i);
        }
        skipList.printAll();
        int delData = 6;
        skipList.delete(delData);
        skipList.printAll();
        int find = 8;
        SNode sNode = skipList.findByValue(find);
        if (null != sNode)
            System.out.println(sNode.toString());
    }
}

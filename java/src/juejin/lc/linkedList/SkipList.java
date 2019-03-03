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
    public SkipList() {
        levelCount = 1;
        head = new SNode();
        random = new Random();
    }

    /**
     * 插入
     * @param data 数组
     */
    private void insert(int data) {

    }

    /**
     * 删除
     * @param data 数组
     */
    private void delete(int data){

    }

    /**
     * 根据value查找
     * @param data 数据
     * @return SNode
     */
    private SNode findByValue(int data){

    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                ++level;
            }
        }
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
        private SNode forwards[] = new SNode[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append(",level:");
            builder.append(maxLevel);
            builder.append("}");
            return builder.toString();
        }
    }

    public static void main(String[] args) {

    }
}

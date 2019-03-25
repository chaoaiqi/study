package juejin.lc.tree;


import java.util.*;

/**
 * 多模式串匹配算法-AC自动机
 */
public class AhoCorasick {

    /**
     * 根节点
     */
    private AcNode root;

    private AhoCorasick() {
        root = new AcNode('/');
    }

    /**
     * 插入
     *
     * @param txt 数据
     */
    private void insert(String txt) {
        AcNode p = root;
        char[] txtChar = txt.toCharArray();
        for (Character c : txtChar) {
            if (!p.children.containsKey(c)) {
                AcNode trieNode = new AcNode(c);
                p.children.put(c, trieNode);
            }
            p = p.children.get(c);
        }
        p.isEndingChar = true;
    }

    /**
     * 构建失败指针
     */
    private void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.poll();
            for (char c : p.children.keySet()) {
                AcNode pChild = p.children.get(c);
                if (null == pChild) continue;
                if (root == p) {
                    pChild.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (null != q) {
                        AcNode qChild = q.children.get(p.data);
                        if (null != qChild) {
                            pChild.fail = qChild;
                            break;
                        }
                        q = q.fail;
                    }
                    if (null == q) {
                        pChild.fail = root;
                    }
                }
                queue.offer(pChild);
            }
        }
    }

    /**
     * 匹配主串
     *
     * @param txt 主串
     */
    private boolean match(String txt) {
        char[] txtChars = txt.toCharArray();
        AcNode p = root;
        for (char c : txtChars) {
            while (p != root && null == p.children.get(c)) {
                p = p.fail;
            }
            p = p.children.get(c);
            //如果没有匹配，从root重新开始
            if (null == p) p = root;
            AcNode temp = p;
            while (temp != root) {
                if (temp.isEndingChar) {
                    return true;
                }
                temp = temp.fail;
            }
        }
        return false;
    }

    /**
     * 构建敏感词trie树
     */
    private void generate() {
        String[] strs = new String[]{"so", "hel", "oh", "llo"};
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
    }

    public static void main(String[] args) {
        AhoCorasick ac = new AhoCorasick();
        ac.generate();
        ac.buildFailurePointer();
        String txt = "he her hello home so see say just so so hello world";
        System.out.println("主串");
        System.out.println("[" + txt + "]");
        System.out.println("敏感词:");
        System.out.println("so,hel,oh,llo");
        String[] strs = txt.split(" ");
        Map<String, Integer> mapCache = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (mapCache.containsKey(strs[i])) {
                int index = mapCache.get(strs[i]);
                mapCache.put(strs[i], ++index);
                strs[i] = "****";
            } else {
                boolean res = ac.match(strs[i]);
                //如果匹配到，将其替换成****
                if (res) {
                    mapCache.put(strs[i], 1);
                    strs[i] = "****";
                }
            }
        }
        System.out.println("经过敏感词系统过滤后...");
        System.out.println(Arrays.toString(strs));
        for (String str:mapCache.keySet()){
            System.out.println(str + "出现的次数为" + mapCache.get(str));
        }
    }


    private class AcNode {
        /**
         * 字符
         */
        public char data;
        /**
         * 子节点
         */
        Map<Character, AcNode> children;
        /**
         * 结束标识
         */
        boolean isEndingChar;
        /**
         * 失败指针
         */
        AcNode fail;

        AcNode(char data) {
            this.data = data;
            children = new HashMap<>();
            isEndingChar = false;
        }
    }
}

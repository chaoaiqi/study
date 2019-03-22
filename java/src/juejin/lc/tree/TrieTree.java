package juejin.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Trie树
 */
public class TrieTree {
    /**
     * 根节点
     */
    private TrieNode root;

    /**
     * 预制单词数量
     */
    private int count;

    private List<String> list;

    /**
     * 存储一个无意义的字符
     */
    private TrieTree() {
        root = new TrieNode('/');
        count = 0;
        list = new ArrayList<>();
    }

    /**
     * 插入
     *
     * @param txt 插入
     */
    private void insert(char[] txt) {
        TrieNode p = root;
        for (char c : txt) {
            //当前字符的ASCII码 - 'a'的 ASCII码
            int index = c - 'a';
            if (null == p.children[index]) {
                TrieNode node = new TrieNode(c);
                p.children[index] = node;
            }
            p = p.children[index];
        }
        ++count;
        p.isEndingChar = true;
    }

    /**
     * 包含
     *
     * @param pattern 字符
     * @return 返回值
     */
    private boolean contains(String pattern) {
        char[] patChars = pattern.toCharArray();
        TrieNode p = root;
        for (char patChar : patChars) {
            int index = patChar - 'a';
            if (null == p.children[index])
                return false;
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    /**
     * 模糊匹配提示
     *
     * @param pattern 前缀
     */
    private void match(String pattern) {
        char[] patChars = pattern.toCharArray();
        TrieNode p = root;
        for (char patChar : patChars) {
            int index = patChar - 'a';
            if (null == p.children[index])
                return;
            p = p.children[index];
        }
        //开始遍历 p,将所有匹配的字符加入strs
        traversal(p, "");
    }

    /**
     * 组装strs
     *
     * @param trieNode 节点
     */
    private void traversal(TrieNode trieNode, String str) {
        if (null != trieNode) {
            str += trieNode.data;
        } else {
            if (!list.contains(str))
                list.add(str);
            return;
        }
        for (int i = 0; i < trieNode.children.length; i++) {
            traversal(trieNode.children[i], str);
        }
    }

    /**
     * 初始化字典树
     */
    private void initTries() {
//        how，hi，her，hello，so，see
//                   /
//              h         s
//           e  i  o    o   e
//         l         w        e
//      l
//   o
//        ps：缩点优化
        char[] how = "how".toCharArray();
        insert(how);
        char[] hi = "hi".toCharArray();
        insert(hi);
        char[] her = "her".toCharArray();
        insert(her);
        char[] hello = "hello".toCharArray();
        insert(hello);
        char[] so = "so".toCharArray();
        insert(so);
        char[] see = "see".toCharArray();
        insert(see);
    }

    private void printAll() {
        for (String s : list) {
            System.out.println(s + "");
        }
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.initTries();
        String str = "hello";
        boolean res = trieTree.contains(str);
        System.out.println("trie树是否包含" + str + "返回结果:" + res);
        String h = "h";
        trieTree.match(h);
        trieTree.printAll();
    }

    public class TrieNode {
        /**
         * 字符
         */
        public char data;
        /**
         * 子节点
         */
        TrieNode[] children;
        /**
         * 标识
         */
        boolean isEndingChar;

        TrieNode(char data) {
            children = new TrieNode[26];
            isEndingChar = false;
            this.data = data;
        }
    }
}

package juejin.lc.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieTreeAlgo {

    /**
     * 根节点
     */
    private TrieNode root;
    /**
     * 计数
     */
    private int count;

    /**
     * 无参构造方法
     */
    private TrieTreeAlgo() {
        root = new TrieNode('/');
        count = 0;
    }

    /**
     * 插入
     *
     * @param txt 数据
     */
    private void insert(String txt) {
        TrieNode p = root;
        char[] txtChar = txt.toCharArray();
        for (Character c : txtChar) {
            if (!p.children.containsKey(c)) {
                TrieNode trieNode = new TrieNode(c);
                p.children.put(c, trieNode);
            }
            p = p.children.get(c);
            ++p.frequency;
        }
        ++count;
        p.isEndingChar = true;
    }

    private int frequency(String pattern) {
        char[] patChars = pattern.toCharArray();
        TrieNode p = root;
        for (char patChar : patChars) {
            if (p.children.containsKey(patChar)) {
                p = p.children.get(patChar);
            }
        }
        if (p.isEndingChar) return p.frequency - p.children.size();
        return -1;
    }

    private void initTries() {
        String txt = "he her hello home so see say just so so hello world";
        String[] strs = txt.split(" ");
        for (String str : strs) {
            insert(str);
        }
    }

    public static void main(String[] args) {
        TrieTreeAlgo trieTreeAlgo = new TrieTreeAlgo();
        trieTreeAlgo.initTries();
        System.out.println("共计" + trieTreeAlgo.count + "个单词。");
        String so = "so";
        int soCount = trieTreeAlgo.frequency(so);
        System.out.println(so + "出现的次数为：" + (soCount > 0 ? soCount : 0));
        String he = "he";
        int heCount = trieTreeAlgo.frequency(he);
        System.out.println(he + "出现的次数为：" + (heCount > 0 ? heCount : 0));
        String hel = "hel";
        int helCount = trieTreeAlgo.frequency(hel);
        System.out.println(hel + "出现的次数为：" + (helCount > 0 ? helCount : 0));
    }

    private class TrieNode {
        /**
         * 字符
         */
        public char data;
        /**
         * 出现频率
         */
        int frequency;

        boolean isEndingChar;
        /**
         * 子节点
         */
        Map<Character, TrieNode> children;

        TrieNode(char data) {
            this.data = data;
            children = new HashMap<>();
            isEndingChar = false;
        }
    }

}

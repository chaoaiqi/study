package juejin.lc.string;

/**
 * KMP算法
 */
public class KMPByDFA {
    /**
     * 模式串
     */
    private String pattern;
    /**
     * 模式串长度
     */
    private int pLen;
    /**
     * 确定优先状态自动机
     */
    private int[][] dfa;

    /**
     * 有参构造方法
     *
     * @param pattern 模式串
     */
    private KMPByDFA(String pattern) {
        this.pattern = pattern;
        this.pLen = pattern.length();
        int aLen = 256;
        dfa = new int[aLen][pLen];
        dfa[pattern.charAt(0)][0] = 1;
        int i = 0;
        for (int j = 1; j < pLen; j++) {
            for (int k = 0; k < aLen; k++) {
                //复制匹配失败情况下的值
                dfa[k][j] = dfa[k][i];
            }
            //设置匹配成功情况下的值
            dfa[pattern.charAt(j)][j] = j + 1;
            //更新重新状态
            i = dfa[pattern.charAt(j)][i];
        }
    }

    /**
     * kmp
     * txt上模拟DFA的运行
     *
     * @param txt 主串
     * @return 返回值
     */
    private int kmpSearch(String txt) {
        int i = 0;
        int j = 0;
        int tLen = txt.length();
        for (; i < tLen && j < pLen; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        //找到匹配，到达模式串的结尾
        if (j == pLen)
            return i - pLen;
        return -1;
    }

    public static void main(String[] args) {
        String txt = "hello world";
        String pattern = "world";
        KMPByDFA kmp = new KMPByDFA(pattern);
        int res = kmp.kmpSearch(txt);
        System.out.println("BM算法匹配结果：" + res);
    }
}

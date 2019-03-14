package juejin.lc.string;

/**
 * BM算法
 * 启发式地处理不匹配的字符
 */
public class BoyerMoore {
    /**
     * 记录
     */
    private int[] records;
    /**
     * 模式串
     */
    private String pattern;
    /**
     * 模式串长度
     */
    private int pLen;

    private BoyerMoore(String pattern) {
        this.pattern = pattern;
        pLen = pattern.length();
        int aLen = 256;
        records = new int[aLen];
        //初始化记录数组，默认-1
        for (int i = 0; i < aLen; i++) {
            records[i] = -1;
        }
        //模式串中的字符在其中出现的最右位置
        for (int j = 0; j < pLen; j++) {
            records[pattern.charAt(j)] = j;
        }
    }

    private int bmSearch(String txt) {
        int tLen = txt.length();
        int skip;
        for (int i = 0; i <= tLen - pLen; i += skip) {
            skip = 0;
            for (int j = pLen - 1; j >= 0; --j) {
                System.out.println(txt.charAt(i + j) + " -- " + pattern.charAt(j));
                if (txt.charAt(i + j) != pattern.charAt(j)) {
                    skip = j - records[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String txt = "hello world";
        String pattern = "world";
        BoyerMoore bm = new BoyerMoore(pattern);
        int res = bm.bmSearch(txt);
        System.out.println("BM算法匹配结果：" + res);
    }
}

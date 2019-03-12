package juejin.lc.string;

/**
 * 朴素匹配算法
 */
public class BFArithmetic {

    /**
     * bf 算法
     *
     * @param txt     主串
     * @param pattern 模式串
     * @return 位置
     */
    private int bfSearch(String txt, String pattern) {
        int tLen = txt.length();
        int pLen = pattern.length();
        if (tLen < pLen) return -1;
        for (int i = 0; i <= tLen - pLen; i++) {
            int j = 0;
            for (; j < pLen; j++) {
                System.out.println(txt.charAt(i + j) + " -- " + pattern.charAt(j));
                if (txt.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == pLen) return i;
        }
        return -1;
    }

    /**
     * bf 算法的变体 显式回退
     *
     * @param txt     主串
     * @param pattern 模式串
     * @return 位置
     */
    private int bfSearchT(String txt, String pattern) {
        int tLen = txt.length();
        int i = 0;

        int pLen = pattern.length();
        int j = 0;

        for (; i < tLen && j < pLen; i++) {
            System.out.println(txt.charAt(i) + " -- " + pattern.charAt(j));
            if (txt.charAt(i) == pattern.charAt(j)) {
                ++j;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == pLen) {
            System.out.println("end... i = " + i + ",plen = " + pLen);
            return i - pLen;
        }
        return -1;
    }

    public static void main(String[] args) {
        BFArithmetic bf = new BFArithmetic();
        String txt = "hello world";
        String pattern = "world";
        int res = bf.bfSearch(txt, pattern);
        System.out.println("BF算法匹配结果:" + res);
//        int resT = bf.bfSearchT(txt, pattern);
//        System.out.println("BF算法(显示回退)匹配结果:" + resT);
    }
}

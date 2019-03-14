package juejin.lc.string;

/**
 * KMP 算法
 */
public class KMPArithmetic {
    /**
     * kmp
     *
     * @param txt     主串
     * @param pattern 模式串
     * @return 返回值
     */
    private int kmpSearch(String txt, String pattern) {
        char[] txtChars = txt.toCharArray();
        int tLen = txtChars.length;
        char[] patChars = pattern.toCharArray();
        int pLen = patChars.length;
        int[] next = getNext(patChars, pLen);
        int index = 0;
        for (int i = 0; i < tLen; i++) {
            while (index > 0 && txtChars[i] != patChars[index]) {
                index = next[index - 1] + 1;
            }
            System.out.println(txtChars[i] + " -- " + patChars[index]);
            if (txtChars[i] == patChars[index])
                ++index;
            if (index == pLen)
                return i - pLen + 1;
        }
        return -1;
    }

    /**
     * 构造失效函数
     *
     * @param patChars 模式串
     * @param pLen     模式串长度
     * @return 返回值
     */
    private int[] getNext(char[] patChars, int pLen) {
        int[] next = new int[pLen];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < pLen; i++) {
            while (k != -1 && patChars[k + 1] != patChars[i]) {
                k = next[k];
            }
            if (patChars[k + 1] == patChars[i])
                ++k;
            next[i] = k;
        }
        System.out.println("好前缀：");
        print(next);
        return next;
    }

    private void print(int[] arrays){
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        KMPArithmetic kmpArithmetic = new KMPArithmetic();
        String txt = "hello world";
        String pattern = "world";
        int res = kmpArithmetic.kmpSearch(txt, pattern);
        System.out.println("KMP算法匹配结果：" + res);
    }
}

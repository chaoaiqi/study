package juejin.lc.string;

/**
 * BM算法
 */
public class BMArithmetic {

    /**
     * 字母表长度
     */
    private int aLen;

    private BMArithmetic() {
        aLen = 256;
    }

    /**
     * BM
     *
     * @param txt     主串
     * @param pattern 模式串
     * @return 返回值
     */
    private int bmSearch(String txt, String pattern) {
        // 记录模式串中每个字符最后出现的位置
        int[] records = new int[aLen];
        char[] txtChars = txt.toCharArray();
        int tLen = txtChars.length;
        char[] patChars = pattern.toCharArray();
        int pLen = patChars.length;
        generateBC(patChars, records);
        int[] suffix = new int[pLen];
        boolean[] prefix = new boolean[pLen];
        generateGS(patChars, suffix, prefix);
        //主串与模式串对齐的第一个字符
        int index = 0;
        while (index <= tLen - pLen) {
            int i = pLen - 1;
            // 模式串从后往前匹配
            for (; i >= 0; --i) {
                // 坏字符对应模式串中的下标是 i
                if (txtChars[index + i] != patChars[i]) break;
            }
            if (i < 0) {
                return index;
            }
            int x = i - records[(int) txtChars[index + i]];
            int y = 0;
            if (i < pLen - 1) {
                y = moveByGS(i, pLen, suffix, prefix);
            }
            System.out.println("x = " + x + ",y = " + y);
            index = index + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 移动
     *
     * @param index  坏字符对应的模式串中的字符下标
     * @param pLen   模式串长度
     * @param suffix 在模式串中，查找跟好后缀匹配的另一个子串
     * @param prefix 记录模式串的后缀子串是否能匹配模式串的前缀子串
     * @return 返回值
     */
    private int moveByGS(int index, int pLen, int[] suffix, boolean[] prefix) {
        int k = pLen - 1 - index; // 好后缀长度
        if (suffix[k] != -1) return index - suffix[k] + 1;
        for (int i = index + 2; i <= pLen - 1; i++) {
            if (prefix[pLen - i])
                return i;
        }
        return -1;
    }

    /**
     * 构建坏字符哈希表
     *
     * @param patChars 模式串
     * @param records  记录表
     */
    private void generateBC(char[] patChars, int[] records) {
        for (int i = 0; i < aLen; i++) {
            records[i] = -1;
        }
        for (int i = 0; i < patChars.length; i++) {
            // 计算 b[i] 的 ASCII 值
            int ascii = (int) patChars[i];
            records[ascii] = i;
        }
        System.out.println("坏字符哈希表：");
        print(records);
    }

    /**
     * 好后缀
     *
     * @param patChars 模式串
     * @param suffix   在模式串中，查找跟好后缀匹配的另一个子串
     * @param prefix   记录模式串的后缀子串是否能匹配模式串的前缀子串
     */
    private void generateGS(char[] patChars, int[] suffix, boolean[] prefix) {
        int pLen = patChars.length;
        for (int i = 0; i < pLen; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < pLen - 1; ++i) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            while (j >= 0 && patChars[j] == patChars[pLen - 1 - k]) {
                --j;
                ++k;
                //j+1 表示公共后缀子串在 patChars[0, i] 中的起始下标
                suffix[k] = j + 1;
            }
            // 如果公共后缀子串也是模式串的前缀子串
            if (j == -1) prefix[k] = true;
        }
    }

    private void print(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != -1)
                System.out.println(i + " -- " + arrays[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BMArithmetic bmArithmetic = new BMArithmetic();
        String txt = "hello world";
        String pattern = "world";
        int res = bmArithmetic.bmSearch(txt, pattern);
        System.out.println("BM算法匹配结果：" + res);
    }
}

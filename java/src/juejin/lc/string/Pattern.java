package juejin.lc.string;


/**
 * 正则表达式
 */
public class Pattern {
    /**
     * 标识
     */
    private boolean match;
    /**
     * 正则表达式
     */
    private char[] patChars;
    /**
     * 长度
     */
    private int plen;

    /**
     * 初始化
     *
     * @param patten 正则表达式
     */
    private Pattern(String patten) {
        patChars = patten.toCharArray();
        this.plen = patChars.length;
        match = false;
    }

    /**
     * 匹配
     *
     * @param txt 文本
     * @return 返回值
     */
    private boolean isMatch(String txt) {
        match = false;
        char[] txtChars = txt.toCharArray();
        int tlen = txtChars.length;
        recursiveMatch(0, 0, txtChars, tlen);
        return match;
    }

    /**
     * 递归匹配
     *
     * @param ti       字符索引
     * @param pj       正则表达式索引
     * @param txtChars 字符
     * @param tlen     字符长度
     */
    private void recursiveMatch(int ti, int pj, char[] txtChars, int tlen) {
        if (match) return;
        if (pj == plen) {
            if (ti == tlen) match = true;
            return;
        }

        if (patChars[pj] == '*') {//* 任意字符
            for (int i = 0; i < tlen - ti; i++) {
                recursiveMatch(ti + i, pj + 1, txtChars, tlen);
            }
        } else if (patChars[pj] == '?') {//? 0 or 1
            recursiveMatch(ti, pj + 1, txtChars, tlen);
            recursiveMatch(ti + 1, pj + 1, txtChars, tlen);
        } else if (ti < tlen && patChars[pj] == txtChars[ti]) {
            recursiveMatch(ti + 1, pj + 1, txtChars, tlen);
        }
    }

    public static void main(String[] args) {
        String patten = "*@c?.com";
        Pattern pattern = new Pattern(patten);
        String txtT = "666@cc.com";
        boolean resT = pattern.isMatch(txtT);
        System.out.println(txtT + "的匹配结果：" + resT);
        String txtF = "666@c.con";
        boolean resF = pattern.isMatch(txtF);
        System.out.println(txtF + "的匹配结果：" + resF);
    }
}

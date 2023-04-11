package juejin.lc.leetCode;

/**
 * 最后一个单词长度
 *
 * @author liuchao
 * @date 2019/5/27
 */
public class LengthOfLastWord {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * 输入: "Hello World"
     * 输出: 5
     *
     * @param s 单词
     * @return 长度
     */
    private int solution(String s) {
        if (null == s || s.trim().length() == 0) {
            return 0;
        }
        String[] strs = s.split(" ");
        if (strs.length == 1) {
            return s.trim().length();
        }
        return strs[strs.length - 1].length();
    }

    /**
     * 高效解法
     *
     * @param s 单词
     * @return 长度
     */
    private int solution2(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                ++count;
            } else if (count != 0) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "Hello World";
        System.out.println(lengthOfLastWord.solution(s));
        String s2 = "     ";
        System.out.println(lengthOfLastWord.solution2(s2));
    }
}

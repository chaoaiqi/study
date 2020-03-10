package juejin.lc.leetCode;

public class IsSubsequence {
    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
     * 而 s 是个短字符串（长度 <=100）。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true.
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * 返回 false.
     * <p>
     * 后续挑战 :
     * <p>
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
     * 在这种情况下，你会怎样改变代码？
     *
     * @param s 字符串
     * @param t 字符串
     * @return 返回结果
     */
    private boolean solution(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean res = isSubsequence.solution(s, t);
        System.out.println("res = " + res);
    }
}

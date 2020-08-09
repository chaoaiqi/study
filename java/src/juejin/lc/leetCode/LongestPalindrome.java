package juejin.lc.leetCode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class LongestPalindrome {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public String solution1(String s) {
        // 边界条件
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int offset = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else  {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1> offset) {
                    offset = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + offset);
    }
    /**
     *  暴力破解法
     * @param s 字符串
     * @return 最长回文串
     */
    public String solution(String s) {
        // 先判断边界条件
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        // 最差情况，给定的字符串没有大于1的回文串情况，取一位
        int offset = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > offset && isPalindrome(chars, i,j)) {
                    begin = i;
                    offset = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + offset);
    }
    public boolean isPalindrome(char[] chars, int begin, int end) {
        // 边界条件 不考虑 begin >= end 情况
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            ++begin;
            --end;
        }
        return true;
    }
}

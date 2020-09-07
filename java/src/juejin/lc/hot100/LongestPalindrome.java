package juejin.lc.hot100;

public class LongestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public String solution(String s) {
        // 动态规划
        // 边界条件
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int offset = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > offset) {
                    begin = i;
                    offset = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + offset);
    }

    public String solution1(String s) {
        // 暴力破解法
        // 边界条件
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int offset = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > offset && isPalindrome(chars, i, j)) {
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

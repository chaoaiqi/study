package juejin.lc.dynamicProgramming;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class LongestCommonSequence {
    /**
     * s1 = “abcbdab”;s2 = "bdcaba"。
     * 4
     *
     * @param s1 string
     * @param s2 string
     * @return 返回最长公共子序列长度
     */
    private int solution(String s1, String s2) {
//        状态转移方程公式
//        dp[0][j] = 0; (0<=j<=m)
//        dp[i][0] = 0; (0<=i<=n)
//        dp[i][j] = dp[i-1][j-1] +1; (str1[i] == str2[j])
//        dp[i][j] = max{dp[i][j-1],dp[i-1][j]}; (str1[i] != str2[j])
//              b  d  c  a  b  a
//         a   [0, 0, 0, 1, 0, 1]
//         b   [1, 1, 1, 1, 2, 2]
//         c   [0, 1, 2, 2, 2, 2]
//         b   [1, 1, 2, 2, 3, 3]
//         d   [0, 2, 2, 2, 3, 3]
//         a   [0, 2, 2, 3, 3, 4]
//         b   [1, 2, 2, 3, 4, 4]
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < str2.length; j++) {
            if (str2[j] == str1[0]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        print(dp);
        int length = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (dp[i][j] == length && stringBuilder.indexOf(String.valueOf(str1[i])) == -1) {
                    stringBuilder.append(str1[i]);
                }
                length = Math.max(length, dp[i][j]);
            }
        }
        System.out.println(stringBuilder.reverse().toString());
        return length;
    }

    private void print(int[][] dp) {
        for (int[] ds : dp) {
            System.out.println(Arrays.toString(ds));
        }
    }

    public static void main(String[] args) {
        LongestCommonSequence longestCommonSubString = new LongestCommonSequence();
        String s1 = "你啊";
        String s2 = "你好啊";
        int res = longestCommonSubString.solution(s1, s2);
        System.out.println(res);
    }
}

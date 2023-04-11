package juejin.lc.dynamicProgramming;

import java.util.Arrays;

/**
 * 最长公共子串
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class LongestCommonSubString {
    /**
     * str1 = “abcbdab”;str2 = "bdcaba",则str1，str2的最长公共子串为ab。
     *
     * @param str1 string
     * @param str2 string
     * @return 返回最长公共子串
     */
    private String solution(String str1, String str2) {
//        构建二阶矩阵
//             b  d  c  a  b  a
//         a  [0, 0, 0, 1, 0, 1]
//         b  [1, 0, 0, 0, 2, 0]
//         c  [0, 0, 1, 0, 0, 0]
//         b  [1, 0, 0, 0, 1, 0]
//         d  [0, 2, 0, 0, 0, 0]
//         a  [0, 0, 0, 1, 0, 1]
//         b  [1, 0, 0, 0, 2, 0]
//        状态转移方程公式
//        dp[i][0] = 0; (0<=i<=m)
//        dp[0][j] = 0; (0<=j<=n)
//        dp[i][j] = dp[i-1][j-1] +1; (str1[i] == str2[j])
//        dp[i][j] = 0; (str1[i] != str2[j])
        int[][] dp = new int[str1.length()][str2.length()];
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();

        for (int i = 0; i < str1Chars.length; i++) {
            if (str1Chars[i] == str2Chars[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < str2Chars.length; j++) {
            if (str2Chars[j] == str1Chars[0]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < str1Chars.length; i++) {
            for (int j = 1; j < str2Chars.length; j++) {
                if (str1Chars[i] == str2Chars[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        print(dp);
        int max = dp[0][0];
        //--> j
        int x = 0;
        // --> i
        int y = 0;
        for (int i = 0; i < str1Chars.length; i++) {
            for (int j = 0; j < str2Chars.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    y = i;
                    x = j;
                    System.out.println(max + "," + x + "," + y);
                }
            }
        }
        System.out.println("=====================");
        System.out.println(max + "," + x + "," + y);

        return resJoint(str1, x, y);
    }

    /**
     * 优化
     * 根据解法1可以找到规律，求最长公共子串可以转换为求二阶矩阵的最大递增对角线问题
     * b  d  c  a  b  a
     * a  [0, 0, 0, 1, 0, 1]
     * b  [1, 0, 0, 0, 2, 0]
     * c  [0, 0, 1, 0, 0, 0]
     * b  [1, 0, 0, 0, 1, 0]
     * d  [0, 2, 0, 0, 0, 0]
     * a  [0, 0, 0, 1, 0, 1]
     * b  [1, 0, 0, 0, 2, 0]
     * 求 2 1
     *
     * @param str1 string
     * @param str2 string
     * @return 返回最长公共子串
     */
    private String solution2(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();
        int x = 0;
        int y = 0;
        int index = 0;
        int max = 0;
        //列
        int row = 0;
        //行
        int col = str2Chars.length - 1;
        //计算矩阵中的每一条斜对角线上的值
        while (row < str1Chars.length) {
            int i = row;
            int j = col;
            while (i < str1Chars.length && j < str2Chars.length) {
                if (str1Chars[i] == str2Chars[j]) {
                    if (++index > max) {
                        max = index;
                        x = j;
                        y = i;
                    }
                } else {
                    index = 0;
                }
                i++;
                j++;
            }
            if (col > 0) {
                --col;
            } else {
                ++row;
            }
        }
        System.out.println(max + "," + x + "," + y);
        return resJoint(str1, x, y);
    }

    private void print(int[][] dp) {
        for (int[] ds : dp) {
            System.out.println(Arrays.toString(ds));
        }
    }

    private String resJoint(String str, int x, int y) {
        StringBuilder stringBuilder = new StringBuilder();
        while (x >= 0 && y >= 0) {
            stringBuilder.append(str.charAt(y--));
            --x;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        System.out.println(longestCommonSubString.solution(
                "hhh刘璐琪#&#开黑的小姐姐#&#李贵人鸟是啥#&#架构师#&#全栈开发",
                "架构师#&#全栈开发"));
    }
}

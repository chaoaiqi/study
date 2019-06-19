package juejin.lc.dynamicProgramming;

/**
 * 最长公共子序列
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class LongestCommonSequence {
    /**
     * str1 = “abcbdab”;str2 = "bdcaba"。
     *
     * @param str1 string
     * @param str2 string
     * @return 返回最长公共子序列长度
     */
    private int solution(String str1, String str2) {
//        状态转移方程公式
//        dp[0][j] = 0; (0<=j<=m)
//        dp[i][0] = 0; (0<=i<=n)
//        dp[i][j] = dp[i-1][j-1] +1; (str1[i-1] == str2[j-1])
//        dp[i][j] = max{dp[i][j-1],dp[i-1][j]}; (str1[i-1] != str2[j-1])
//           a b c b d a b
//        b  0 1 0 1 0 0 1
//        d  0 0 0 0 1 0 0
//        c  0 0 1 0 0 0 0
//        a  1 0 0 0 0 1 0
//        b  0 1 0 1 0 0 1
//        a  1 0 0 0 0 1 0
        return 0;
    }
}

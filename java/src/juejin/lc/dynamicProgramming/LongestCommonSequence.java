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
     * 4
     * @param s1 string
     * @param s2 string
     * @return 返回最长公共子序列长度
     */
    private int solution(String s1, String s2) {
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
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < str2.length; j++) {
            if (str2[j] == str1[0]){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int length = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                length = Math.max(length,dp[i][j]);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestCommonSequence longestCommonSubString = new LongestCommonSequence();
        String s1 = "abcbdab";
        String s2 = "bdcaba";
        int res = longestCommonSubString.solution(s1,s2);
        System.out.println(res);
    }
}

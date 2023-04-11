package juejin.lc.dynamicProgramming;

import java.util.Arrays;

/**
 * 0-1 背包问题
 *
 * @author liuchao
 * @date 2019/6/20
 */
public class BackPack01 {
    /**
     * 穷举 回溯 动态规划 递归 贪心算法
     *
     * @param v 体积
     * @param p 重量
     * @param c 总重量
     */
    private int solution(int[] v, int[] p, int c) {
//        状态转移方程
//        假设有N件物品和一个容量为V的背包。第i件物品的体积是v[i]，价值是p[i]，将哪些物品装入背包可使价值总和最大？
//        每一种物品都有两种可能即放入背包或者不放入背包。
//        可以用dp[i][j]表示第i件物品放入容量为j的背包所得的最大价值，则状态转移方程可以推出如下：
//        dp[i][0] = dp[0][j] = 0 (i > 0,j > 0)
//        dp[i][j] = dp[i-1][j] (j < v[i])
//        dp[i][j] = max{dp[i-1][j], dp[i-1][j-v[i]]+p[i]}
//            0  1  2  3  4  5  6  7  8
//        0  [0, 0, 0, 0, 0, 0, 0, 0, 0]
//        1  [0, 0, 3, 3, 3, 3, 3, 3, 3]
//        2  [0, 0, 3, 4, 4, 7, 7, 7, 7]
//        3  [0, 0, 3, 4, 5, 7, 8, 9, 9]
//        4  [0, 0, 3, 4, 5, 7, 8, 9, 10]
        int[][] dp = new int[v.length][c + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (j < v[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + p[i]);
                }
            }
        }
        print(dp);
        int[] items = new int[v.length];
        situation(items, v, p, dp, v.length - 1, c);
        System.out.println("回溯选中的物品：（1表示选中）");
        System.out.println("体积：" + Arrays.toString(v));
        System.out.println("价格：" + Arrays.toString(p));
        System.out.println("选中：" + Arrays.toString(items));
        return dp[v.length - 1][c];
    }

    private void situation(int[] items, int[] v, int[] p, int[][] dp, int i, int j) {
        if (i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                situation(items, v, p, dp, i - 1, j);
            } else if (j - v[i] >= 0 && dp[i][j] == dp[i - 1][j - v[i]] + p[i]) {
                items[i] = 1;
                situation(items, v, p, dp, i - 1, j - v[i]);
            }
        }
    }

    private void print(int[][] dp) {
        for (int[] ds : dp) {
            System.out.println(Arrays.toString(ds));
        }
    }

    public static void main(String[] args) {
        // 0 占位
        int[] v = {0, 2, 3, 4, 5};
        int[] p = {0, 3, 4, 5, 6};
        int c = 8;
        BackPack01 backPack01 = new BackPack01();
        int max = backPack01.solution(v, p, c);
        System.out.println("当体积为" + c + "时，最大价值为" + max);
    }
}

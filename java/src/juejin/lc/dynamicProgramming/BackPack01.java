package juejin.lc.dynamicProgramming;

/**
 * 0-1 背包问题
 * @author liuchao
 * @date 2019/6/20
 */
public class BackPack01 {
    /**
     * 穷举 回溯 动态规划 递归 贪心算法
     * @param nums 数组
     * @param max 重量
     */
    private void solution(int[] nums,int max){
//        状态转移方程
//        假设有N件物品和一个容量为V的背包。第i件物品的体积是v[i]，价值是c[i]，将哪些物品装入背包可使价值总和最大？
//        每一种物品都有两种可能即放入背包或者不放入背包。
//        可以用dp[i][j]表示第i件物品放入容量为j的背包所得的最大价值，则状态转移方程可以推出如下：
//        dp[i][j]=max{dp[i-1][j-v[i]]+c[i],dp[i-1][j]};
    }
}

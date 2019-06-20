package juejin.lc.dynamicProgramming;

/**
 * 最大子序列和
 * @author liuchao
 * @date 2019/6/19
 */
public class MaxSubsequenceSum {
    /**
     *
     * @param nums 传入数组
     * @return 返回值
     */
    private int solution(int[] nums){
//        状态转移方程公式
//        dp[1] = a1; (a1>=0 && i == 1)
//        dp[i] = dp[i-1]+ai; (ai>=0 && i>=2)
//        dp[i] = 0; (dp[i-1] + ai <=0 && i>=2)
//        比如 [-2,1,-3,4,-1,2,1,-5,4]
//        取连续子数组 [4,-1,2,1] 的和最大，为 6
        return 0;

    }
}

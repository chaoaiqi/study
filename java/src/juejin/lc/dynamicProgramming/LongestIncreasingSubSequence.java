package juejin.lc.dynamicProgramming;

/**
 * 最长递增子序列
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class LongestIncreasingSubSequence {
    /**
     * 最长递增子序列（Longest Increasing Subsequence）是指找到一个给定序列的最长子序列的长度,使得子序列中的所有元素单调递增。
     * 例如：{ 3,5,7,1,2,8 } 的 LIS 是 { 3,5,7,8 },长度为 4。
     *
     * @param nums 数组
     * @return 返回长度
     */
    private int solution(int[] nums) {
        //推公式
        //F[i] = max{1,F[j]+1|aj<ai && j<i}
        int[] F = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            F[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && F[i] < F[j] + 1) {
                    F[i] = F[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (F[i] > max) {
                max = F[i];
            }
            System.out.println("F[" + i + "] = " + F[i]);
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 1, 2, 8};
        int res = new LongestIncreasingSubSequence().solution(nums);
        System.out.println(res);
    }
}

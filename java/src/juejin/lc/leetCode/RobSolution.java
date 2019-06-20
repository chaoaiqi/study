package juejin.lc.leetCode;

import java.util.Arrays;

/**
 * 打家劫舍
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class RobSolution {
    /**
     * memo[i] 表示考虑抢劫 nums[i...n]表示所能获得的最大收益
     */
    private int[] memo;

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * @param nums 数据
     * @return 返回值
     */
    private int rob(int[] nums) {
//        思路： 记忆化搜索法
//        ① 状态：考虑抢劫 nums[index...num.length） 这个范围内的所有房子
//        ② 状态转移：tryRob(n) = Max{rob(0) + tryRob(2), rob(1) + tryRob(3)... rob(n-3) + tryRob(n-1), rob(n-2), rob(n-1)}
        memo = new int[nums.length];
        //填充数组，默认-1
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    /**
     * 尝试
     * 自顶向上
     *
     * @param nums  数组
     * @param index 位置
     * @return 返回结果
     */
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        //记忆化搜索可以避免重复子问题的重复运算
        System.out.println("memo[" + index + "] = " + memo[index]);
        if (memo[index] != -1) {
            return memo[index];
        }
        //下面是对状态转移方程的描述
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            System.out.println("res-before|" + i + ": " + res);
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
            System.out.println("res-after|" + i + ": " + res);
        }
        System.out.println("res = " + res);
        memo[index] = res;
        return res;
    }

    /**
     * 自底向下 动态规划
     *
     * @param nums 数组
     * @return 返回结果
     */
    private int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
        int[] memo = new int[n];
        // 先考虑最简单的情况
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
            memo[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : memo[i + 2]), nums[i + 1] + (i + 3 >= n ? 0 : memo[i + 3]));
        }
        return memo[0];
    }

    private int solution(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        System.out.println(memo[0] + "," + memo[1]);
        for (int i = 2; i < n; i++) {
            System.out.println("memo[i - 1]=" + memo[i - 1] + ",nums[i]=" + nums[i] + ",memo[i - 2] =" + memo[i - 2] + " ,i=" + i);
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        }
        return memo[n - 1];
    }

    public static void main(String[] args) {
        RobSolution robSolution = new RobSolution();
        int[] nums = {2, 1, 1, 2};
        int res = robSolution.solution(nums);
        System.out.println(res);
    }
}

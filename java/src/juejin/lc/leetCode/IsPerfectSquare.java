package juejin.lc.leetCode;

public class IsPerfectSquare {
    /**
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * <p>
     * 说明：不要使用任何内置的库函数，如  sqrt。
     * <p>
     * 示例 1：
     * <p>
     * 输入：16
     * 输出：True
     * 示例 2：
     * <p>
     * 输入：14
     * 输出：False
     *
     * @param num 正整数
     * @return 是否是完全平方数
     */
    private boolean solution(int num) {
        // 牛顿迭代法 天下第一
        if (num == 1) {
            return true;
        }
        long x = num >> 1;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return (x * x == num);
    }

    private boolean solution1(int num) {
        // 常规思路
        if (num == 1) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long guessSquared = mid * mid;
            if (guessSquared > num) {
                right = mid - 1;
            } else if (guessSquared < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        int num = 2147395600;
        boolean result = isPerfectSquare.solution(num);
        System.out.println("result = " + result);
    }
}

package juejin.lc.leetCode;

public class IsPowerOfThree {
    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 27
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: 0
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: true
     * 示例 4:
     * <p>
     * 输入: 45
     * 输出: false
     *
     * @param n 给定整数
     * @return 返回结果
     */
    private boolean solution(int n) {
        // 换底公式
        // ps 不能使用 log ，否则会有精度问题
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    private boolean solution2(int n) {
        // 1162261467 是 整数范围内最大的3的幂次方
        return n > 0 && 1162261467 % n == 0;
    }

    private boolean solution1(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        int n = 16;
        boolean result = isPowerOfThree.solution(n);
        System.out.println(result);
    }
}

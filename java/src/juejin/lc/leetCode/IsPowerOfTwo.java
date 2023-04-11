package juejin.lc.leetCode;

public class IsPowerOfTwo {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     * 示例 2:
     * <p>
     * 输入: 16
     * 输出: true
     * 解释: 24 = 16
     * 示例 3:
     * <p>
     * 输入: 218
     * 输出: false
     *
     * @param n 指定整数
     * @return 是否是2的幂次方
     */
    private boolean solution(int n) {
//        若 n = 2^x
//        x且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件：
//        恒有 n & (n - 1) == 0，这是因为：
//        nn 二进制最高位为 1，其余所有位为 0；
//        n - 1 二进制最高位为 0，其余所有位为 1；
//        一定满足 n > 0。
//        因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^x
        return n > 0 && (n & (n - 1)) == 0;
    }

    private boolean solution1(int n) {
        return n > 0 && (n & -n) == n;
    }
}

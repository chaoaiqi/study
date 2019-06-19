package juejin.lc.leetCode;

/**
 * 阶乘后的0
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class TrailingZeroes {
    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * @param n 数值
     * @return 0个数
     */
    public int solution(int n) {
        if (n < 5) {
            return 0;
        } else {
            return n / 5 + solution(n / 5);
        }
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        int res = trailingZeroes.solution(9);
        System.out.println(res);
    }
}

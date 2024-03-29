package juejin.lc.leetCode;

public class ArrangeCoins {
    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     * <p>
     * 示例 1:
     * n = 5
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * 因为第三行不完整，所以返回2.
     * <p>
     * 示例 2:
     * n = 8
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     * 因为第四行不完整，所以返回3.
     *
     * @param n
     * @return
     */
    public int solution(int n) {
        // 边界条件
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int index = 0;
        int num = n;
        for (int i = 1; i < n; i++) {
            if (num - i >= 0) {
                num -= i;
                ++index;
            } else {
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = new ArrangeCoins().solution(n);
        System.out.println("res = " + res);
    }
}

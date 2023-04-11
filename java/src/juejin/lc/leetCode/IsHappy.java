package juejin.lc.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 肥宅快乐数
 *
 * @author liuchao
 * @date 2019/7/15
 */
public class IsHappy {
    private Map map = new HashMap();

    /**
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
     * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     * 输入: 19
     * 输出: true
     * 解释:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     *
     * @param n 快乐数
     * @return 返回结果
     */
    private boolean solution(int n) {
//        快慢指针思想解决该问题，思路类似判断环
        int slow = n;
        int fast = n;
        do {
            slow = recursion(slow);
            fast = recursion(fast);
            fast = recursion(fast);
        } while (slow != fast);
        return fast == 1;
    }

    private int recursion(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2;
        IsHappy isHappy = new IsHappy();
        boolean res = isHappy.solution(n);
        System.out.println("res = " + res);
    }
}

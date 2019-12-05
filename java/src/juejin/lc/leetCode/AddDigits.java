package juejin.lc.leetCode;

public class AddDigits {
    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     * 进阶:
     * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     *
     * @param num 非负整数
     * @return 个位数结果
     */
    private int solution(int num) {
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num = num / 10;
        }
        sum += num;
        if (sum > 9) {
            return solution(sum);
        }
        return sum;
    }
    private int optimalSolution(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        int num = 10;
        AddDigits addDigits = new AddDigits();
        int result = addDigits.solution(num);
        System.out.println("result = " + result);
    }
}

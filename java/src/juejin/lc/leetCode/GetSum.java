package juejin.lc.leetCode;

public class GetSum {
    /**
     * 不使用运算符 + 和 -，计算两整数a 、b之和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: a = 1, b = 2
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: a = -2, b = 3
     * 输出: 1
     * TODO
     * @param a 整数 a
     * @param b 整数 b
     * @return 整数和
     */
    private int solution(int a, int b) {
        //进位
        int jw = a & b;
        System.out.println("first jw = " + jw);
        //相加位
        a = a ^ b;
        System.out.println("first a = " + a);
        System.out.println();
        while (jw != 0) {
            //左移进位作为新的b
            b = jw << 1;
            System.out.println("b  = " + b);
            //进位
            jw = a & b;
            System.out.println("jw  = " + jw);
            //相加位
            a = a ^ b;
            System.out.println("a  = " + a);
        }
        return a;
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        int a = 2;
        int b = 3;
        int sum = getSum.solution(a, b);
        System.out.println("sum = " + sum);
    }
}

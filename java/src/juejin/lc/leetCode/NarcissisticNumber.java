package juejin.lc.leetCode;

/**
 * 水仙花数
 * 求1000以内的水仙花数
 * 153，370，371，407
 * 153 = 1*1*1 + 5*5*5 + 3 * 3 * 3;
 *
 * @author liuchao
 * @date 2019/8/22
 */
public class NarcissisticNumber {
    private static void solution() {
        // 首先一定是三位数
        for (int i = 100; i < 1000; i++) {
            int unit = i % 10;
            int ten = (i / 10) % 10;
            int hundred = (i / 10 / 10) % 10;
            if (i == (unit * unit * unit + ten * ten * ten + hundred * hundred * hundred)) {
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        solution();
    }
}

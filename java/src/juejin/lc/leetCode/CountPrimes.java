package juejin.lc.leetCode;

import java.util.Arrays;

public class CountPrimes {
    /**
     * 统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     *
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * @param n 输入
     * @return 输出
     */
    private int solution(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组舒适化为true
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]){
                for (int j = i * i; j < n; j+=i) {
                    System.out.println("j = " + j);
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <n ; i++) {
            if (isPrim[i]){
                ++count;
            }
        }
        return count;
    }
    private int solution1(int n) {
        // 常规思路，但是如果n过大，效率太低
        int num = 0;
        for (int i = n - 1; i > 1; i--) {
            boolean flag = true;
            int j = 2;
            for (; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
                if (j > Math.sqrt(i)) {
                    break;
                }
            }
            System.out.println("j = " + j + ",flag = " + flag);
            if (flag){
                ++num;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int n = 10;
        int res = countPrimes.solution(n);
        System.out.println("res = " + res);
    }
}

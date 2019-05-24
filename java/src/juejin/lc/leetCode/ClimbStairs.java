package juejin.lc.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author liuchao
 * @date 2019/5/24
 */
public class ClimbStairs {
    public int solution(int n){
    int[] arrs = new int[n + 1];
        return recursion(arrs,n);
    }

    public int climbStairs2(int n){
        if (n == 1) {
            return 1;
        }
        int[] arrs = new int[n + 1];
        arrs[1] = 1;
        arrs[2] = 2;
        for (int i = 3; i <= n; i++) {
            arrs[i] = arrs[i - 1] + arrs[i - 2];
            System.out.println("arrs[" + i + "] = " + arrs[i]);
        }
        return arrs[n];
    }
    private int recursion(int[] arrs, int n) {
        if (n < 3){
            return n;
        }
        if (arrs[n] > 0){
            return arrs[n];
        }else{
            arrs[n] = recursion(arrs,n - 1) + recursion(arrs,n - 2);
        }
        return arrs[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 4;
        System.out.println(climbStairs.climbStairs2(n));
    }
}

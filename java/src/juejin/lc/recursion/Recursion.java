package juejin.lc.recursion;

import java.util.HashMap;

/**
 * 1.三种方式实现递归
 * 2.解决斐波那契数列问题
 *
 * @author mic
 */
public class Recursion {

    /**
     * 缓存计算结果，防止重复
     */
    private HashMap<Integer, Integer> resCache;

    /**
     * 构造方法
     */
    public Recursion() {
        resCache = new HashMap<Integer, Integer>();
    }

    /**
     * 递归 1、1、2、3、5、8、13、21、34、……
     *
     * @return
     */
    public int recursion(int num) {
        // 一定要先给出递归跳出条件
        if (num < 3)
            return 1;
        // resCache是一个HashMap，key是num，value是res
        if (resCache.containsKey(num)) {
            return resCache.get(num);
        }
        int res = recursion(num - 1) + recursion(num - 2);
        resCache.put(num, res);
        return res;
    }

    /**
     * 尾递归
     *
     * @param num
     * @param first  第一个数
     * @param second 第二个数
     * @return
     */
    public int tailRecursion(int num, int first, int second) {
        if (num < 3)
            return 1;
        if (num == 3)
            return first + second;
        return tailRecursion(num - 1, second, first + second);
    }

    /**
     * 非递归实现
     *
     * @param num
     * @return
     */
    public int commonRcursion(int num) {
        if (num < 3) return 1;
        int first = 1;
        int second = 1;
        int res = 0;
        for (int i = 1; i < num - 1; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    /**
     * 基于数组的实现
     *
     * @param num
     * @return
     */
    public int arrayRecursion(int num) {
        if (num < 3) return 1;
        int[] arrays = new int[num + 1];
        arrays[1] = 1;
        arrays[2] = 1;
        for (int i = 3; i <= num; i++) {
            arrays[i] = arrays[i - 1] + arrays[i - 2];
        }
        return arrays[num];
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int num = 10;
        int res = recursion.recursion(num);
        System.out.println("递归：" + res);
        int tailRes = recursion.tailRecursion(num, 1, 1);
        System.out.println("尾递归：" + tailRes);
        int comRes = recursion.commonRcursion(num);
        System.out.println("常规实现：" + comRes);
        int arrayRes = recursion.arrayRecursion(num);
        System.out.println("基于数组的实现：" + arrayRes);
    }

}

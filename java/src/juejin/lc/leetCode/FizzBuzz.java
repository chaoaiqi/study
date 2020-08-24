package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 示例：
     *
     * n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     * @param n
     * @return
     */
    public List<String> solution(int n) {
        if (n <= 0) {
            return  new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int index = 0;
            if (i % 3 == 0) {
                index += 1;
            }
            if (i % 5 == 0) {
                index += 2;
            }
            switch (index) {
                case 0:
                    list.add(String.valueOf(i));
                    break;
                case 1:
                    list.add("Fizz");
                    break;
                case 2:
                    list.add("Buzz");
                    break;
                default:
                    list.add("FizzBuzz");
                    break;
            }

        }
        return list;
    }
    public List<String> solution1(int n) {
        if (n <= 0) {
            return  new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if ("".equals(str)) {
                str += i;
            }
            list.add(str);
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> list = new FizzBuzz().solution(n);
        System.out.println(list);
    }
}

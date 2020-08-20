package juejin.lc.leetCode;

import java.util.HashMap;

public class ToHex {
    /**
     * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     * 注意:
     * 十六进制中所有字母(a-f)都必须是小写。
     * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；
     * 对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
     * 给定的数确保在32位有符号整数范围内。
     * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     * 示例 1：
     *
     * 输入:
     * 26
     *
     * 输出:
     * "1a"
     * 示例 2：
     *
     * 输入:
     * -1
     *
     * 输出:
     * "ffffffff"
     * @param num
     * @return
     */
    public String solution(int num) {
        // 思路，采用位运算
        StringBuilder stringBuilder = new StringBuilder();
        char[] dic = "0123456789abcdef".toCharArray();
        while (num != 0) {
            // 与运算
            // 复习一下常用运算符
            // | 按位或    只有有一则为一
            // & 按位与    均为一则为一
            // ^ 按位异或  相同为零不同为一
            int res = num & 15;
            stringBuilder.append(dic[res]);
            System.out.println("res = " + res);
            // 右移四位
            num = num >>> 4;
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("0");
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        int num = -287;
        String res = new ToHex().solution(num);
        System.out.println("res = " + res);
    }
}

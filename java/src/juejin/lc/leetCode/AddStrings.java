package juejin.lc.leetCode;

public class AddStrings {
    /**
     * 大数相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        // 边界条件 默认num1和num2均不为null
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int index = 0;
        StringBuffer ans = new StringBuffer();
        while (n1 >= 0 || n2 >= 0 || index != 0) {
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int result = x + y + index;
            ans.append(result % 10);
            index = result / 10;
            --n1;
            --n2;
        }
        return ans.reverse().toString();
    }
}

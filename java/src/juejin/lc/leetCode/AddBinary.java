package juejin.lc.leetCode;

/**
 * 二进制求和
 *
 * @author liuchao
 * @date 2019/5/27
 */
public class AddBinary {
    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     * @param a 二进制数字
     * @param b 二进制数字
     * @return 返回结果
     */
    public String solution(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while (al >= 0 || bl >= 0 || carry == 1) {
            if (al >= 0 && a.charAt(al--) == '1') {
                ++carry;
            }
            if (bl >= 0 && b.charAt(bl--) == '1') {
                ++carry;
            }
            stringBuilder.append(carry % 2);
            carry /= 2;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary.solution(a,b));
    }
}

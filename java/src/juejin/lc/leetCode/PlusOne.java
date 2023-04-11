package juejin.lc.leetCode;

/**
 * 加一
 *
 * @author liuchao
 * @date 2019/5/27
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits 数组
     * @return 返回值
     */
    private int[] solution(int[] digits) {
        // 5 + 1 = 6 常规
        // 9 + 1 = 10 末尾是9 需要整体向右平移一位 digits[0] = 1
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                flag = true;
            } else {
                flag = false;
                digits[i] += 1;
                break;
            }
        }
        // 9的情况，需要做数组右移操作
        int[] newDigits = null;
        if (flag) {
            newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
        } else {
            newDigits = digits;
        }
        return newDigits;
    }


    public static void main(String[] args) {
        int[] digits = {8, 9, 9};
        int[] res = new PlusOne().solution(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

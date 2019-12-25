package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseVowels {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "hello"
     * 输出: "holle"
     * 示例 2:
     * <p>
     * 输入: "leetcode"
     * 输出: "leotcede"
     * 说明:
     * 元音字母不包含字母"y"。
     *
     * @param s 字符串
     * @return 返回值
     */
    private String solution(String s) {
        // 双指针
        String vowel = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (vowel.contains(chars[i] + "")) {
                if (vowel.contains(chars[j] + "")) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    ++i;
                    --j;
                } else {
                    --j;
                }
            } else {
                ++i;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String s = "leetcode";
        String result = reverseVowels.solution(s);
        System.out.println("result = " + result);
    }
}

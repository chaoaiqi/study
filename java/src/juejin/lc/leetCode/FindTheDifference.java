package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifference {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * <p>
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * <p>
     * 请找出在 t 中被添加的字母。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入：
     * s = "abcd"
     * t = "abcde"
     * <p>
     * 输出：
     * e
     * <p>
     * 解释：
     * 'e' 是那个被添加的字母。
     *
     * @param s 字符串
     * @param t 字符串
     * @return res
     */
    private char solution(String s, String t) {
        char  difference = 0;
        for (int i = 0; i < s.length(); i++) {
            difference ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            difference ^= t.charAt(i);
        }
        return difference;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        FindTheDifference findTheDifference = new FindTheDifference();
        char res = findTheDifference.solution(s,t);
        System.out.println("res = " + res);
    }
}

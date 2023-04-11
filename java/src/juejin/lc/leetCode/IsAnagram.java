package juejin.lc.leetCode;

import juejin.lc.arithmetic.Array;

import java.util.Arrays;

public class IsAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * @param s 字符串
     * @param t 字符串
     * @return r
     */
    private boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     * 高阶解法
     *
     * @param s 字符串
     * @param t 字符串
     * @return r
     */
    private boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++counter[s.charAt(i) - 'a'];
            --counter[t.charAt(i) - 'a'];
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++table[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < t.length(); i++) {
            --table[t.charAt(i) - 'a'];
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "anagram";
        String t = "nagram";
        boolean result = isAnagram.solution(s, t);
        System.out.println("result = " + result);
    }
}

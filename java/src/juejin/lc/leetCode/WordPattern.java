package juejin.lc.leetCode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
     *
     * @param pattern 规则
     * @param str     字符串
     * @return 是否匹配
     */
    private boolean solution(String pattern, String str) {
        String[] strs = str.split(" ");
        char[] chars = pattern.toCharArray();
        Map<Character, String> map = new HashMap<>(strs.length);
        if (strs.length != chars.length) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(chars[i]) && !map.containsValue(strs[i])) {
                map.put(chars[i], strs[i]);
            } else {
                String value = map.get(chars[i]);
                if (!strs[i].equals(value) || "".equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        WordPattern wordPattern = new WordPattern();
        boolean result = wordPattern.solution(pattern, str);
        System.out.println("result = " + result);
    }
}

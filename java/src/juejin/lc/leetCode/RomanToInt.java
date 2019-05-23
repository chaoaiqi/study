package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 罗马数字转整数
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @author liuchao
 * @date 2019/5/22
 */
public class RomanToInt {
    /**
     * 规则
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * @param s 字符串
     * @return 返回值
     */
    private int solution(String s) {
        Map<String, Integer> map = initDictionary();
        //临时变量，存储前一位
        char temp = s.charAt(0);
        String[] strs = new String[s.length()];
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (temp != '\0') {
                if (checkCombo(temp, cur)) {
                    strs[index++] = temp + "" + cur;
                    temp = '\0';
                } else {
                    strs[index++] = temp + "";
                    temp = cur;
                }
            } else {
                temp = cur;
            }
        }
        if (temp != 0) {
            strs[index] = temp + "";
        }
        int sums = 0;
        for (int i = 0; i < strs.length; i++) {
            if (null != strs[i]) {
                sums += map.get(strs[i]);
            }
        }
        return sums;
    }

    /**
     * 判断当前字符是否可以组合
     *
     * @param prev    前
     * @param current 当前
     * @return 返回结果
     */
    private boolean checkCombo(char prev, char current) {
        String expression = String.valueOf(prev);
        String str = String.valueOf(current);
        switch (expression) {
            case "I":
                //IV  4    IX 9
                if ("V".equals(str) || "X".equals(str)) {
                    return true;
                }
                break;
            case "X":
                // XL  40    XC 90
                if ("L".equals(str) || "C".equals(str)) {
                    return true;
                }
                break;
            case "C":
                // CD 400   CM  900
                if ("D".equals(str) || "M".equals(str)) {
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * 声明一个罗马数组关系映射的字典
     *
     * @return map对象
     */
    private Map<String, Integer> initDictionary() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        return map;
    }

    public static void main(String[] args) {
        //2019
        String s = "MCMXCIV";
        RomanToInt romanToInt = new RomanToInt();
        int result = romanToInt.solution(s);
        System.out.println(result);
    }
}

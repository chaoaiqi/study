package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanConstruct {
    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
     * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
     * 如果可以构成，返回 true ；否则返回 false。
     * <p>
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
     * <p>
     * 注意：
     * <p>
     * 你可以假设两个字符串均只含有小写字母。
     * <p>
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     * @param ransomNote 赎金信
     * @param magazine   杂志
     * @return 返回结果
     */
    private boolean solution(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        int[] caps = new int[26];
        for (char ransomNoteChar : ransomNoteChars) {
            int index = magazine.indexOf(ransomNoteChar, caps[ransomNoteChar - 'a']);
            if (index == -1) {
                return false;
            }
            caps[ransomNoteChar - 'a'] = index + 1;
        }
        return true;
    }

    private boolean solution1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character magazineChar : magazineChars) {
            list.add(magazineChar);
        }
        for (Character ransomNoteChar : ransomNoteChars) {
            if (list.contains(ransomNoteChar)) {
                list.remove(ransomNoteChar);
            } else {
                return false;
            }
        }
        return true;
    }
}

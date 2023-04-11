package juejin.lc.leetCode;

import java.util.Stack;

/**
 * 判断是否是有效括号
 *
 * @author liuchao
 * @date 2019/5/23
 */
public class IsValidParentheses {
    /**
     * 规则
     * () true
     * ()[]{} true
     * {[]} true
     * (] false
     * ([)] false
     *
     * @param s 字符串
     * @return 返回结果
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (checkFull(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 校验是否完整
     *
     * @param prev    栈里的
     * @param current 当前
     * @return 返回结果
     */
    private boolean checkFull(Character prev, char current) {
        return (prev == '(' && current == ')') || (prev == '[' && current == ']') || (prev == '{' && current == '}');
    }

    public static void main(String[] args) {
        IsValidParentheses isValidParentheses = new IsValidParentheses();
        System.out.println(isValidParentheses.isValid("()[]{}"));
        System.out.println(isValidParentheses.isValid("()"));
        System.out.println(isValidParentheses.isValid("{[]}"));
        System.out.println(isValidParentheses.isValid("(]"));
        System.out.println(isValidParentheses.isValid("([)]"));
    }
}

package juejin.lc.stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.包含 + - * / 的简易计算器 2.暂时不考虑括号
 *
 * @author mic
 */
public class SimpleCalculator {

    /**
     * 存储数值的栈
     */
    private Stack<Integer> valStack;

    /**
     * 存储运算符的栈
     */
    private Stack<String> calStack;

    /**
     * 计算结果
     */
    private Integer result;


    public SimpleCalculator() {
        valStack = new Stack<Integer>();
        calStack = new Stack<String>();
    }

    /**
     * 简易计算器
     *
     * @param str
     * @return
     */
    public void process(String str) {
//		这里不做非空检验,默认传入的值一定正确有效
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (isNumber(strs[i])) {// 数字
                valStack.push(Integer.valueOf(strs[i]));
            } else {// 运算符
                calDeal(strs[i]);
            }
            print();
        }
        while (!valStack.isEmpty() && !calStack.isEmpty()) {
            String cal = calStack.pop();
            Integer fInteger = valStack.pop();
            Integer sInteger = valStack.pop();
            result = calulate(cal, sInteger, fInteger);
            valStack.push(result);
            print();
        }
        valStack.clear();
        calStack.clear();
    }

    /**
     * 准备计算
     */
    private void calDeal(String opt) {
        //出栈
        String calStar;
        if (!calStack.isEmpty()) {
            while (!calStack.isEmpty()) {
                calStar = calStack.pop();
                if (!compareOperator(opt, calStar)) {
                    Integer p = valStack.pop();
                    Integer q = valStack.pop();
                    result = calulate(calStar, q, p);
                    valStack.push(result);
                } else {
                    calStack.push(calStar);
                    calStack.push(opt);
                    break;
                }
            }
        }
        if (calStack.isEmpty()) {
            calStack.push(opt);
        }
    }

    /**
     * 计算
     *
     * @param opt 四则运算符
     * @param p
     * @param q
     * @return
     */
    private Integer calulate(String opt, Integer p, Integer q) {
        switch (opt) {
            case "+":
                return p + q;
            case "-":
                return p - q;
            case "*":
                return p * q;
            case "/":
                return p / q;
            default:
                break;
        }
        return null;
    }

    /**
     * 比较运算符优先级 true说明curcal优先级高 false说明curcal优先级低，或者是和tarCal优先级相同
     *
     * @param curCal 当前运算符
     * @param tarCal 目标运算符
     * @return
     */
    private boolean compareOperator(String curCal, String tarCal) {
        switch (tarCal) {
            case "+":
            case "-":
                if ("-".equals(curCal) || "+".equals(curCal)) {
                    return false;
                }
                return true;
            case "*":
            case "/":
                return false;
            default:
                break;
        }
        return true;
    }

    private boolean isNumber(String str) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            return true;
        return false;
    }

    private void print() {
        System.out.print("数值栈：" + valStack.toString() + " 运算符栈：" + calStack.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // str的每一个数字和运算符之间均有一个空格来隔离
        String str = "7 - 1 + 2 * 3 + 12 / 2";
        simpleCalculator.process(str);
        System.out.println(str + " = " + simpleCalculator.result);
    }

}

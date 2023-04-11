package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 买入股票的最佳时机
 *
 * @author liuchao
 * @date 2019/5/29
 */
public class MaxProfit {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices 价格数组
     * @return 利润
     */
    public int solution(int[] prices) {
//        动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int minProfit = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minProfit);
            minProfit = Math.min(minProfit, prices[i]);
        }
        return maxProfit;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices 价格数组
     * @return 返回值
     */
    private int solution2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
            System.out.println("prices[i] - prices[i - 1] = " + (prices[i] - prices[i - 1]));
        }
        return maxProfit;
    }

    /**
     * 暴力破解法超出时间限制
     *
     * @param prices
     * @return
     */
    private int solution3(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int curProfit = prices[j] - prices[i];
//                System.out.println("i = " + i + ", j = " + j + ", curProfit = " + curProfit);
                if (maxProfit < curProfit) {
                    maxProfit = curProfit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 归约法
     *
     * @param prices
     * @return
     */
    private int solution4(int[] prices) {
        int[] profits = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }
        // 转成成求最大子序列和
        System.out.println(Arrays.toString(profits));
        int sum = 0;
        int maxProfits = 0;
        for (int i = 0; i < profits.length; i++) {
            sum = sum > 0 ? sum + profits[i] : profits[i];
            System.out.println("i = " + i + ", sum = " + sum + ", maxProfits = " + maxProfits);
            if (maxProfits < sum) {
                maxProfits = sum;
            }
        }
        return maxProfits;
    }

    /**
     * 贪心法
     *
     * @param prices
     * @return
     */
    private int solution5(int[] prices) {
        int minPrices = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrices);
            System.out.println("i = " + i + ", minPrices = " + minPrices + ", maxProfit = " + maxProfit);
        }

        return maxProfit;
    }

    /**
     * 贪心法2
     *
     * @param prices
     * @return
     */
    private int solution6(int[] prices) {
        int minPrices = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrices;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (profit < 0) {
                minPrices = prices[i];
            }
        }

        return maxProfit;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    private int solution7(int[] prices) {
        //buyIn[i]表示第i天第最低最低买入价；
        //saleOut[i]表示第i天第最大收益；
        //第i天的最大收益，要么就是第i-1的收益，要么就是用第i天的价格卖出buyIn[i-1]买入的价格
        int[] buyIn = new int[prices.length];
        int[] saleOut = new int[prices.length];

        buyIn[0] = prices[0];
        saleOut[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            saleOut[i] = Math.max(prices[i] - buyIn[i - 1], saleOut[i - 1]);
            buyIn[i] = Math.min(prices[i], buyIn[i - 1]);
        }
        return Math.max(saleOut[prices.length - 1], 0);
    }

    /**
     * 动规变形
     *
     * @param prices
     * @return
     */
    private int solution8(int[] prices) {
        int[] deltaPrices = new int[prices.length - 1];
        for (int i = 0; i < deltaPrices.length; i++) {
            deltaPrices[i] = prices[i + 1] - prices[i];
        }
        int maxProfit = maxSubArray(deltaPrices);
        return Math.max(maxProfit, 0);
    }

    private int maxSubArray(int[] deltaPrices) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < deltaPrices.length; i++) {
            sum += deltaPrices[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            //思想来自DP，如果一个sum为负，无论nums[i+1]是什么，那么nums[i+1]一定比nums[i+1]+sum大；
            //因此可以找到从i+1开始新的子数组；
            if (sum < 0) {
                sum = 0;
            }
            //假设我们现在的sum就是maxSum，那么下一个数是一个负数，加入sum之后，sum变小了，但sum>0;
        }

        return maxSum;
    }

    private int solution9(int[] prices) {
        return Math.max(maxSubArrayProfit(prices, 0, prices.length - 1), 0);
    }

    private int maxSubArrayProfit(int[] prices, int left, int right) {
        int arrayLength = right - left + 1;
        if (arrayLength <= 3) {
            int maxProfit = 0;
            for (int i = left; i < right; i++) {
                for (int j = i + 1; j < arrayLength; j++) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
            return maxProfit;
        }
        //[0,1,2,3,4,5,6], (5-4)/2 + 4 = 4. 因此midIndex，也就是说midIndex+1永远有意义，如果left<right.
        int mid = (right - left) / 2 + left;

        int rightMaxProfit = maxSubArrayProfit(prices, mid + 1, right);
        int leftMaxProfit = maxSubArrayProfit(prices, left, mid);
        int midMaxProfit = maxProfitContainsMidIndex(prices, mid, left, right);

        return Math.max(midMaxProfit, Math.max(leftMaxProfit, rightMaxProfit));
    }

    private int maxProfitContainsMidIndex(int[] prices, int mid, int left, int right) {
        int leftMin;
        int rightMax;

        if (left < mid) {
            leftMin = getMinNumber(prices, left, mid);
        } else {
            leftMin = prices[mid];
        }
        if (right > mid + 1) {
            rightMax = getMaxNumber(prices, mid + 1, right);
        } else {
            rightMax = prices[mid + 1];
        }
        return rightMax - leftMin;
    }

    private int getMaxNumber(int[] prices, int start, int end) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (maxSum <= prices[i]) {
                maxSum = prices[i];
            }
        }
        return maxSum;
    }

    private int getMinNumber(int[] prices, int start, int end) {
        int minSum = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (minSum > prices[i]) {
                minSum = prices[i];
            }
        }
        return minSum;
    }

    private int solution10(int[] prices) {
        MinMaxStack minStack = new MinMaxStack();
        MinMaxStack maxStack = new MinMaxStack();
        int maxProfit = 0;
        int minPrice = prices[0];
        minStack.push(minPrice);

        for (int i = prices.length - 1; i > 0; i--) {
            maxStack.push(prices[i]);
        }
        System.out.println("maxStack: " + maxStack);
        for (int i = 1; i < prices.length; i++) {
            int profit = maxStack.getMax() - minStack.getMin();
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            int price = maxStack.remove();
            System.out.println("i = " + i + ", maxStack: " + maxStack);
            minStack.push(price);
        }
        return maxProfit;
    }


    class MinMaxStack {
        List<Integer> stack;
        List<Integer> minStack;
        List<Integer> maxStack;

        public MinMaxStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            maxStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.add(x);
            int maxStackValue = Integer.MIN_VALUE;
            int minStackValue = Integer.MAX_VALUE;
            if (minStack.size() > 0) {
                minStackValue = minStack.get(minStack.size() - 1);
            }
            if (maxStack.size() > 0) {
                maxStackValue = maxStack.get(maxStack.size() - 1);
            }
            minStack.add(Math.min(minStackValue, x));
            maxStack.add(Math.max(maxStackValue, x));
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
            maxStack.remove(maxStack.size() - 1);
        }

        public int remove() {
            minStack.remove(minStack.size() - 1);
            maxStack.remove(maxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(minStack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }

        public int getMax() {
            return maxStack.get(maxStack.size() - 1);
        }

        @Override
        public String toString() {
            return "MinMaxStack{" +
                    "stack=" + stack +
                    ", minStack=" + minStack +
                    ", maxStack=" + maxStack +
                    '}';
        }
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices3 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit.solution10(prices3));
    }
}

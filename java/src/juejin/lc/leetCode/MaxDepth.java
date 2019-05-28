package juejin.lc.leetCode;

import java.util.LinkedList;

/**
 * 二叉树的最大深度
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class MaxDepth {
    private int solution(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int ll = solution(root.left);
            int rl = solution(root.right);
            return Math.max(ll, rl) + 1;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        int depth = maxDepth.solution(root);
        System.out.println(depth);
    }
}

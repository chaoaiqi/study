package juejin.lc.leetCode;

/**
 * 二叉树的最大深度
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class MaxDepth {
    private int solution(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            return Math.max(solution(root.left), solution(root.right)) + 1;
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

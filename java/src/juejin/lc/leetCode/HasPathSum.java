package juejin.lc.leetCode;

/**
 * 路径总和
 * @author liuchao
 * @date 2019/5/29
 */
public class HasPathSum {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root 二叉树
     * @param sum 路径总和
     * @return 返回结果
     */
    public boolean solution(TreeNode root, int sum) {
        if (null == root){
            return false;
        }
        if (null == root.left && null == root.right){
            return sum - root.val == 0;
        }
        return solution(root.left,sum - root.val) || solution(root.right,sum - root.val);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

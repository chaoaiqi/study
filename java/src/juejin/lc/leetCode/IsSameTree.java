package juejin.lc.leetCode;

import javax.swing.tree.TreeNode;

/**
 * 相同的树
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class IsSameTree {

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1:
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * [1,2,3],   [1,2,3]
     * 输出: true
     * 示例 2:
     * 输入:      1          1
     * /           \
     * 2             2
     * [1,2],     [1,null,2]
     * 输出: false
     * 示例 3:
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * [1,2,1],   [1,1,2]
     * 输出: false
     *
     * @param p 二叉树p
     * @param q 二叉树q
     * @return 返回结果
     */
    private boolean solution(TreeNode p, TreeNode q) {
        if (null == p && q == null) {
            return true;
        }
        if (null != p && null != q && p.val == q.val) {
            return solution(p.left, q.left) && solution(p.right, q.right);
        }
        return false;
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
        IsSameTree isSameTree = new IsSameTree();
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(-5);
//        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(0);
//        q.left = null;
        q.left = new TreeNode(-8);
//        q.right = new TreeNode(3);
        System.out.println(isSameTree.solution(p, q));
    }
}

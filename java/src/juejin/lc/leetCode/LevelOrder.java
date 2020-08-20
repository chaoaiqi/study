package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *  
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> child = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (null != node) {
                    child.add(node.val);
                    if (null != node.left) {
                        linkedList.offer(node.left);
                    }
                    if (null != node.right) {
                        linkedList.offer(node.right);
                    }
                }
            }
            list.add(child);
        }
        return list;
}
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package juejin.lc.leetCode;

/**
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，
 * 但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class InvertTree {
    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root 二叉树
     * @return 反转后的二叉树
     */
    private TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = solution(root.left);
        root.left = solution(root.right);
        root.right = left;
        return root;
    }
    private TreeNode createTreeNode(){
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        return treeNode;
    }
    private void preOrderTraversal(TreeNode tree) {
        if (null == tree){
            return;
        }
        System.out.print(tree.val + " ");
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        TreeNode treeNode = invertTree.createTreeNode();
        invertTree.preOrderTraversal(treeNode);
        System.out.println();
        TreeNode node = invertTree.createTreeNode();
        TreeNode result = invertTree.solution(node);
        invertTree.preOrderTraversal(result);
    }
}

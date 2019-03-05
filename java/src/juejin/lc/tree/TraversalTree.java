package juejin.lc.tree;

/**
 * 二叉树的遍历
 */
public class TraversalTree {
    /**
     * 前序遍历
     * 根左右
     */
    public void preOrderTraversal(Node tree) {
        if (null == tree) return;
        System.out.print(tree.data + " ");
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
    }

    /**
     * 中序遍历
     * 左根右
     */
    public void inOrderTraversal(Node tree) {
        if (null == tree) return;
        postOrderTraversal(tree.left);
        System.out.print(tree.data + " ");
        postOrderTraversal(tree.right);
    }

    /**
     * 后序遍历
     * 左右根
     */
    public void postOrderTraversal(Node tree) {
        if (null == tree) return;
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        System.out.print(tree.data + " ");
    }
}

package juejin.lc.tree;

import juejin.lc.queue.LinkedQueue;

import java.util.LinkedList;

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
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }

    /**
     * 中序遍历
     * 左根右
     */
    public void inOrderTraversal(Node tree) {
        if (null == tree) return;
        inOrderTraversal(tree.left);
        System.out.print(tree.data + " ");
        inOrderTraversal(tree.right);
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

    /**
     * 按层遍历
     *
     * @param tree
     */
    public void levelTraversal(Node tree) {
        if (null == tree) return;
        LinkedList<Node> linkedList = new LinkedList<Node>();
        Node node = null;
        linkedList.offer(tree);
        while (!linkedList.isEmpty()) {
            node = linkedList.poll();
            System.out.print(node.data + " ");
            if (null != node.left) {
                linkedList.offer(node.left);
            }
            if (null != node.right) {
                linkedList.offer(node.right);
            }
        }

    }
}

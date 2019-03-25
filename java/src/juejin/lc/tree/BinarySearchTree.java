package juejin.lc.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    /**
     * 根节点
     */
    private Node tree;

    /**
     * 插入
     *
     * @param data 数据
     */
    private void insert(int data) {
        if (null == tree) {
            tree = new Node(data);
            return;
        }
        Node node = tree;
        while (null != node) {
            if (data > node.data) {
                if (null == node.right) {
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            } else {
                if (null == node.left) {
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            }
        }
    }

    /**
     * 删除
     *
     * @param data 数据
     */
    private void delete(int data) {
        Node node = tree;
        //node的父节点
        Node pNode = null;
        while (null != node && node.data != data) {
            pNode = node;
            if (data > node.data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (null == node) return;
        if (null != node.left && null != node.right) {
            Node p = node.right;
            //p的父节点
            Node pp = node;
            while (null != p.left) {
                pp = p.left;
                p = p.left;
            }
            //删除操作
            node.data = p.data;
            node = p;
            pNode = pp;
        }
        Node child;
        if (null != node.left) {
            child = node.left;
        } else if (null != node.right) {
            child = node.right;
        } else {
            child = null;
        }
        if (null == pNode) {
            tree = child;
        } else if (pNode.left == null) {
            pNode.left = child;
        } else {
            pNode.right = child;
        }
    }

    private Node find(int data) {
        Node node = tree;
        while (null != node) {
            if (data > node.data) {
                node = node.right;
            } else if (data < node.data) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 查找二叉搜索树的最大节点
     *
     * @return
     */
    private Node findMaxNode() {
        if (null == tree) return null;
        Node node = tree;
        while (null != node.right) {
            node = node.right;
        }
        return node;
    }

    /**
     * 查找二叉搜索树的最小节点
     *
     * @return
     */
    private Node findMinNode() {
        if (null == tree) return null;
        Node node = tree;
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    /**
     * 查找某个节点的前驱节点
     *
     * @param node
     * @return 前驱节点
     */
    private Node findPreNode(Node node) {
        if (null == node) return null;
        if (null != node.left) {
            Node left = node.left;
            while (null != left.right) {
                left = left.right;
            }
            return left;
        }
        return null;
    }

    /**
     * 查找某个节点后续节点
     *
     * @param node
     * @return 后继节点
     */
    private Node findNextNode(Node node) {
        if (null == node) return null;
        if (null != node.right) {
            Node right = node.right;
            while (null != right.left) {
                right = right.left;
            }
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TraversalTree traversalTree = new TraversalTree();
        binarySearchTree.insert(24);
        binarySearchTree.insert(8);
        binarySearchTree.insert(11);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(36);
        binarySearchTree.insert(77);
        binarySearchTree.insert(25);
        binarySearchTree.insert(33);
        binarySearchTree.insert(18);
        //          24
        //     8           36
        //  6    11     25    77
        //    7     18      33
//        System.out.println("前序遍历:");
//        traversalTree.preOrderTraversal(binarySearchTree.tree);
//        System.out.println();
//        System.out.println("中序遍历:");
//        traversalTree.inOrderTraversal(binarySearchTree.tree);
//        System.out.println();
//        System.out.println("后序遍历:");
//        traversalTree.postOrderTraversal(binarySearchTree.tree);
//        System.out.println();
//        System.out.println("层级遍历:");
//        traversalTree.levelTraversal(binarySearchTree.tree);
//        int delete = 8;
//        binarySearchTree.delete(delete);
        System.out.println();
        Node maxNode = binarySearchTree.findMaxNode();
        if (null != maxNode) System.out.println("最大的节点的值为:" + maxNode.data);
        Node minNode = binarySearchTree.findMinNode();
        if (null != minNode) System.out.println("最小的节点的值为:" + minNode.data);
        System.out.println();
        int find = 24;
        Node node = binarySearchTree.find(find);
        Node preNode = binarySearchTree.findPreNode(node);
        if (null != preNode) System.out.println("前驱节点的值为:" + preNode.data);
        Node nextNode = binarySearchTree.findNextNode(node);
        if (null != nextNode) System.out.println("后驱节点的值为:" + nextNode.data);
    }
}

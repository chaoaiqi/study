package juejin.lc.tree;

/**
 * AVL树
 */
public class AVLTree {
    /**
     * 根
     */
    private Node root;

    /**
     * 插入
     */
    private void insert(int data) {
        if (null == root) {
            root = new Node(data, null);
        } else {
            Node node = root;
            Node parent;
            while (node.data != data) {
                parent = node;
                boolean goleft = node.data > data;
                node = goleft ? node.left : node.right;
                if (null == node) {
                    if (goleft) {
                        parent.left = new Node(data, parent);
                    } else {
                        parent.right = new Node(data, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
    }

    /**
     * 删除
     *
     * @param node 节点
     */
    private void delete(Node node) {
        if (null == node.left && null == node.right) {
            if (null == node.parent) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
        }
        if (null != node.left) {
            Node child = node.left;
            while (null != child.right) {
                child = child.right;
            }
            node.data = child.data;
            delete(child);
        } else {
            Node child = node.right;
            if (null != child) {
                while (null != child.left) {
                    child = child.left;
                }
                node.data = child.data;
                delete(child);
            }
        }
    }

    /**
     * 自平衡
     *
     * @param node 根
     */
    private void rebalance(Node node) {
        setBalance(node);
        if (node.balance == -2) {
            if (getHeight(node.left.left) < getHeight(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (node.balance == 2) {
            if (getHeight(node.right.right) < getHeight(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        if (null != node.parent) {
            rebalance(node.parent);
        } else {
            root = node;
        }
    }

    /**
     * 左
     *
     * @param node 节点
     * @return 返回值
     */
    private Node rotateLeft(Node node) {
        Node right = node.right;
        right.parent = node.parent;
        node.right = right.left;
        if (null != node.right)
            node.right.parent = node;
        right.left = node;
        node.parent = right;
        if (null != right.parent) {
            if (right.parent.right == node) {
                right.parent.right = right;
            } else {
                right.parent.left = right;
            }
        }
        setBalance(node, right);
        return right;
    }

    /**
     * 右旋
     *
     * @param node 节点
     * @return 返回值
     */
    private Node rotateRight(Node node) {
        Node left = node.left;
        left.parent = node.parent;
        node.left = left.right;
        if (null != node.left)
            node.left.parent = node;
        left.right = node;
        node.parent = left;
        if (null != left.parent) {
            if (left.parent.right == node) {
                left.parent.right = left;
            } else {
                left.parent.left = left;
            }
        }
        setBalance(node, left);
        return left;
    }

    /**
     * set
     *
     * @param nodes 节点
     */
    private void setBalance(Node... nodes) {
        for (Node node : nodes) {
            if (null != node) {
                //重置高度
                node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
                node.balance = getHeight(node.right) - getHeight(node.left);
            }
        }
    }

    /**
     * 获取树高度
     *
     * @param node 节点
     * @return 返回值
     */
    private int getHeight(Node node) {
        if (null != node)
            return node.height;
        return -1;
    }

    private void print() {
//        TraversalTree traversalTree = new TraversalTree();
//        System.out.println("前序遍历");
//        traversalTree.preOrderTraversal(root);
//        System.out.println();
//        System.out.println("中序遍历");
//        traversalTree.inOrderTraversal(root);
//        System.out.println();
//        System.out.println("后序遍历");
//        traversalTree.postOrderTraversal(root);
//        System.out.println();
//        System.out.println("层级遍历");
//        traversalTree.levelTraversal(root);
        print(root);
    }

    private void print(Node node) {
        if (null != node) {
            print(node.left);
            System.out.println(node.data + " " + node.balance);
            print(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 1; i < 10; i++) {
            avlTree.insert(i);
        }
        avlTree.print();

    }

    public class Node {
        /**
         * 数据
         */
        int data;
        /**
         * 高度
         */
        int height;
        /**
         * 平衡标识
         */
        int balance;
        /**
         * 左子树
         */
        Node left;
        /**
         * 右子树
         */
        Node right;
        /**
         * 根
         */
        Node parent;

        /**
         * 有参构造方法
         *
         * @param data   数据
         * @param parent 父节点
         */
        Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }
}

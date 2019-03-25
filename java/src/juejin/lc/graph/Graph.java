package juejin.lc.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的两种暴力搜索算法
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int count;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    /**
     * 有参构造方法
     *
     * @param count 数量
     */
    @SuppressWarnings("unchecked")
    private Graph(int count) {
        this.count = count;
        adj = new LinkedList[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 图的一条边存两次
     *
     * @param oSide order
     * @param rSide reversed order
     */
    private void add(int oSide, int rSide) {
        adj[oSide].add(rSide);
        adj[rSide].add(oSide);
    }

    /**
     * 广度优先搜索
     *
     * @param oSide 顺序边
     * @param rSide 逆序边
     */
    private void bfs(int oSide, int rSide) {
        if (oSide == rSide) return;

        boolean[] visited = new boolean[count];
        visited[oSide] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(oSide);
        int[] prev = new int[count];
        for (int i = 0; i < count; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int j = 0; j < adj[index].size(); j++) {
                int value = adj[index].get(j);
                if (!visited[value]) {
                    prev[value] = index;
                    if (value == rSide) {
                        print(prev, oSide, rSide);
                    }
                    visited[value] = true;
                    queue.offer(value);
                }
            }
        }
    }

    private boolean found = false;

    /**
     * 深度优先搜索
     *
     * @param oSide 顺序边
     * @param rSide 逆序边
     */
    private void dfs(int oSide, int rSide) {
        boolean[] visited = new boolean[count];
        int[] prev = new int[count];
        for (int i = 0; i < count; i++) {
            prev[i] = -1;
        }
        recursiveDfs(visited, prev, oSide, rSide);
        print(prev, oSide, rSide);
    }

    /**
     * 递归
     *
     * @param visited visited
     * @param prev    prev
     * @param oSide   顺序边
     * @param rSide   逆序边
     */
    private void recursiveDfs(boolean[] visited, int[] prev, int oSide, int rSide) {
        if (found) return;
        visited[oSide] = true;
        if (oSide == rSide) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[oSide].size(); i++) {
            int value = adj[oSide].get(i);
            if (!visited[value]) {
                prev[value] = oSide;
                recursiveDfs(visited, prev, value, rSide);
            }
        }
    }

    private void createGraph() {
        //  0 -- 1 -- 2
        //  |    |    |
        //  3 -- 4 -- 5
        //  |    |    |
        //  6 -- 7 -- 8
        add(0, 1);//add(1,0);
        add(0, 3);//add(3,0);

        add(1, 2);//add(2,1);
        add(1, 4);// add(4,1);

        add(2, 5);//add(5,2);

        add(3, 4);//add(4,3);
        add(3, 6);//add(6,3);

        add(4, 5);//add(5,4);
        add(4, 7);// add(7,4);

        add(5, 8);//add(8,5);

        add(6, 7);//add(7,6);

        add(7, 8);//add(8,7);
    }

    /**
     * 递归正向输出图的路径
     *
     * @param prev  prev
     * @param oSide 顺序边
     * @param rSide 逆序边
     */
    private void print(int[] prev, int oSide, int rSide) {
        if (prev[rSide] != -1 && oSide != rSide) {
            print(prev, oSide, prev[rSide]);
        }
        System.out.print(rSide + " ");
    }

    public static void main(String[] args) {
        int count = 9;
        Graph graph = new Graph(count);
        //  0 -- 1 -- 2
        //  |    |    |
        //  3 -- 4 -- 5
        //  |    |    |
        //  6 -- 7 -- 8
        graph.createGraph();
        System.out.println("BFS(广度优先搜索)");
        graph.bfs(0, 8);
        System.out.println();
        System.out.println("DFS(深度优先搜索)");
        graph.dfs(0, 8);
    }
}

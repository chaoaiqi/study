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
    public void add(int oSide, int rSide) {
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
                    if (index == rSide) {
                        print(prev, oSide, rSide);
                    }
                }
            }
        }
    }

    private void dfs(){

    }

    private void print(int[] prev, int oSide, int rSide) {
        if (prev[rSide] != -1 && oSide != rSide) {
            print(prev, oSide, prev[rSide]);
        }
        System.out.print(rSide + " ");
    }

    public static void main(String[] args) {

    }
}

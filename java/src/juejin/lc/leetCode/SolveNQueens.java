package juejin.lc.leetCode;

/**
 * N皇后
 */
public class SolveNQueens {
    /**
     * 皇后数组
     */
    private int[] queens;
    /**
     * n皇后
     */
    private int n;
    /**
     * 摆法数量
     */
    private int count;

    /**
     * 基于8皇后而衍生的N皇后
     *
     * @param n 皇后的数量
     */
    private SolveNQueens(int n) {
        queens = new int[n];
        this.n = n;
        count = 0;
    }

    /**
     * ]
     * 调用方式 calNQueens(0)从0开始遍历
     *
     * @param row 行
     */
    private void calNQueens(int row) {
        if (row == n) {
            printQueens(queens);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSatisfy(row, col)) {
                queens[row] = col;
                calNQueens(row + 1);
            }
        }
    }

    /**
     * 遍历判断是否满足
     *
     * @param row 行
     * @param col 列
     * @return 返回值
     */
    private boolean isSatisfy(int row, int col) {
//        System.out.println("(" + row + "," + col + ")");
        int leftUp = col - 1;
        int rightUp = col + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (queens[i] == col) return false;
            if (leftUp >= 0 && queens[i] == leftUp) return false;
            if (rightUp < n && queens[i] == rightUp) return false;
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] queens) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
        ++count;
    }

    public static void main(String[] args) {
        int n = 8;
        SolveNQueens solveNQueens = new SolveNQueens(n);
        solveNQueens.calNQueens(0);
        System.out.println("共计" + solveNQueens.count + "种摆法.");
    }
}

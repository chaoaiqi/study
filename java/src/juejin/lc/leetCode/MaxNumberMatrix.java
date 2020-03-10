package juejin.lc.leetCode;

public class MaxNumberMatrix {
    /**
     * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
     * TODO
     * @param matrix 二维矩阵
     * @param k      整数
     * @return 最大矩形和
     */
    private int solution(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int max = matrix[0][0];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                System.out.println("matrix[" + i + "][" + j + "] = " + matrix[i][j]);
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 25;
        MaxNumberMatrix maxNumberMatrix = new MaxNumberMatrix();
        int result = maxNumberMatrix.solution(matrix, k);
        System.out.println("result = " + result);
    }
}

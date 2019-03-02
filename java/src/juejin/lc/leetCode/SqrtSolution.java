package juejin.lc.leetCode;


/**
 * mic
 */
public class SqrtSolution {

    /**
     * 求一个正整数的平方根
     *
     * @param num   正整数
     * @param range 范围
     * @return 返回值
     */
    private double mySqrt(int num, double low, double high, double range) {
        double mid = (low + high) / 2f;
//        System.out.println("mid = " + mid);
        if (num - mid * mid < 0 ) {
            return  mySqrt(num,low,(mid + high)/2f,range);
        }else{
            if (num - mid * mid > range){
                return  mySqrt(num,(low + mid)/2f,high,range);
            }
            String str = String.format("%.6f",mid);
            return Double.valueOf(str);
        }
    }

    public static void main(String[] args) {
        SqrtSolution sqrtSolution = new SqrtSolution();
        int num = 2;
        double range = 0.000001f;
        double res = sqrtSolution.mySqrt(num, 0, num, range);
        System.out.println(res);
    }
}

package juejin.lc.leetCode;

public class HammingWeight {
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                ++num;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 521;
        HammingWeight hammingWeight = new HammingWeight();
        int res = hammingWeight.solution(n);
        System.out.println("res = " + res);
    }
}

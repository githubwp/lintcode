package algorithm.jiandan;

public class CoinProblem {
    public static int coinProblem(int n, int m) {
        // Write your code here
        int remain = n - m;
        int num = 0;
        int[] all = new int[]{100, 50, 20, 10, 5, 2, 1};
        for (int i : all) {
            int tempNum = remain / i;
            remain = remain % i;
            num += tempNum;
            if (remain == 0) {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(coinProblem(200, 61));
        System.out.println(coinProblem(100, 29));
        System.out.println(coinProblem(50, 5));
    }
}

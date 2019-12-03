package algorithm.zhongdeng;



public class BackPack1 {
    /**
     * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack1(int m, int[] A) {
        // write your code here
        int[] f = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }

    //不成立
    public static int backPack(int m, int[] A) {
        // write your code here
        int[] f = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 4, 8, 5};
        int m = 10;
        System.out.println(backPack(m, A));
        int[] A1 = new int[]{2, 3, 5, 7};
        int m1 = 12;
        System.out.println(backPack(m1, A1));
    }
}

package algorithm.zhongdeng;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // write your code here
        int[] sum = new int[amount + 1];
        Arrays.fill(sum, -1);
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > amount) {
                break;
            }
            if (sum[coin] == 1) {
                continue;
            }
            sum[coin] = 1;
        }
        sum[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (sum[i] == 1) {
                continue;
            }
            for (int coin : coins) {
                if (coin < i && sum[i - coin] != -1) {
                    if (sum[i] == -1) {
                        sum[i] = sum[i - coin] + 1;
                    } else {
                        sum[i] = Math.min(sum[i], sum[i - coin] + 1);
                    }
                    if (sum[i] == 2) {
                        break;
                    }
                }
            }
        }
        return sum[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 3, 5}, 7));
    }
}

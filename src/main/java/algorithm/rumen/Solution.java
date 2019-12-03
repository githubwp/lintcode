package algorithm.rumen;

import java.util.Arrays;

public class Solution {
    /**
     * @param A:      An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public static void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int v1 = A[index1];
        A[index1] = A[index2];
        A[index2] = v1;
    }
/*

    描述
    给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。

    样例
    对于数组 [3, 2, 1, 4, 5], 排序后为：[1, 2, 3, 4, 5]。

*/

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] A) {
        // write your code here
        Arrays.sort(A);
        //冒泡排序
//        for (int j = 0; j < A.length - 1; j++) {
//            for (int i = A.length - 1; i >= 1; i--) {
//                if (A[i - 1] > A[i]) {
//                    int v1 = A[i-1];
//                    A[i-1] = A[i];
//                    A[i] = v1;
//                }
//            }
//        }
    }



    /*
    反转一个只有3位数的整数。

你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。

您在真实的面试中是否遇到过这个题？
样例
123 反转之后是 321。
900 反转之后是 9。
     */

    public static int reverseInteger(int number) {
        // write your code here
//        return number % 10 * 100 + number % 100 / 10 * 10 + number / 100;
        char[] c = (number + "").toCharArray();
        char temp = c[0];
        c[0] = c[2];
        c[2] = temp;
        return Integer.parseInt(c[0] + "" + c[1] + "" + c[2]);
    }

    /**
     * @param character: a character
     * @return: a character
     */
    public static char lowercaseToUppercase(char character) {
        // write your code here
        if (character >= 97) {
            return (char) (character - 32);
        } else {
            return (char) (character + 32);
        }
    }

    /*
    366. 斐波纳契数列
        查找斐波纳契数列中第 N 个数。
        所谓的斐波纳契数列是指：
        前2个数是 0 和 1 。
        第 i 个数是第 i-1 个数和第i-2 个数的和。
        斐波纳契数列的前10个数字是：
                0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
        样例
        给定 1，返回 0
        给定 2，返回 1
        给定 10，返回 34
        注意事项
        The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

        80% 数据通过测试总耗时 1100 ms
        输入
        41
        期望答案
        102334155
        提示
        你的代码运行时间超过了限制，检查你的时间复杂度。TLE通常是由死循环造成的，思考一下你的时间复杂度是否是最优的。
     */
    public static int fibonacci1(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static int fibonacci2(int n) {
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                r[i] = i;
            } else {
                r[i] = r[i - 2] + r[i - 1];
            }
        }
        return r[n - 1];
    }

    public static int fibonacci(int n) {

        int[] r = new int[3];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                r[i] = i;
            } else {
                r[2] = r[0] + r[1];
                r[0] = r[1];
                r[1] = r[2];
            }
        }
        return r[n < 2 ? n : 2];
    }

    public static int digitCounts(int k, int n) {
        // write your code here
        int num = 0;
        String kstr = String.valueOf(k);
        for (int i = 0; i <= n; i++) {
            for (String s : String.valueOf(i).split("")) {
                if (s.equals(kstr)) {
                    num++;
                }
            }
        }
        return num;
    }
    public static int digitCounts1(int k, int n) {
        // write your code here
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num / 10 != 0) {
                //比10大
                if (num % 10 == k) {
                    sum++;
                }
                //右移
                num = num / 10;
            }
            //比10小
            if (num == k) {
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(digitCounts(7, 12345));
        System.out.println(digitCounts1(7, 12345));
        System.out.println(digitCounts(1, 1));
        System.out.println(digitCounts1(1, 1));
    }
}

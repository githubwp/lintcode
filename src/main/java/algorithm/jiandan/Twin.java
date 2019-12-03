package algorithm.jiandan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twin {
    /*
    描述
    给定两个字符串 s和t，每次可以任意交换s的奇数位或偶数位上的字符，即奇数位上的字符能与其他奇数位的字符互换，而偶数位上的字符能与其他偶数位的字符互换，问能否经过若干次交换，使s变成t。

    字符串长度均不超过100000100000
    字符串可由大写字母、小写字母及数字组成
    您在真实的面试中是否遇到过这个题？
    样例
    给出 s="abcd"，t="cdab"，返回"Yes"。

    解释：
    第一次a与c交换，第二次b与d交换。
    给出 s="abcd"，t="bcda"，返回"No"。

    解释：
    无论如何交换，都无法得到bcda。
    */

    public static String isTwin1(String s, String t) {
        // Write your code here
        //把s和t的奇偶数位提出来，排序后作对比，相等则可以

        if (s.length() != t.length()) {
            return "No";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int len = s.length();

        char[] sOddArr = new char[len / 2 + 1];
        char[] sEvenArr = new char[len / 2 + 1];
        char[] tOddArr = new char[len / 2 + 1];
        char[] tEvenArr = new char[len / 2 + 1];

        for (int i = 0; i < len; i = i + 2) {
            int offset = ((i + 1) / 2);
            sOddArr[offset] = sArr[i];
            tOddArr[offset] = tArr[i];
            if (i + 1 < len) {
                sEvenArr[offset] = sArr[i + 1];
                tEvenArr[offset] = tArr[i + 1];
            }
        }
        Arrays.sort(sOddArr);
        Arrays.sort(tOddArr);
        Arrays.sort(sEvenArr);
        Arrays.sort(tEvenArr);
        if (Arrays.toString(sOddArr).equals(Arrays.toString(tOddArr)) && Arrays.toString(sEvenArr).equals(Arrays.toString(tEvenArr))) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static String isTwin(String s, String t) {
        if (s.length() != t.length()) {
            return "No";
        }
        Map<Character, Integer> sMapOdd = new HashMap<>(s.length()/2);
        Map<Character, Integer> tMapOdd = new HashMap<>(t.length()/2);
        Map<Character, Integer> sMapEven = new HashMap<>(s.length()/2);
        Map<Character, Integer> tMapEven = new HashMap<>(t.length()/2);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sMapEven.merge(s.charAt(i), 1, (integer, integer2) -> integer + integer2);
                tMapEven.merge(t.charAt(i), 1, (integer, integer2) -> integer + integer2);
            } else {
                sMapOdd.merge(s.charAt(i), 1, (integer, integer2) -> integer + integer2);
                tMapOdd.merge(t.charAt(i), 1, (integer, integer2) -> integer + integer2);
            }
        }
        if (sMapEven.equals(tMapEven) && sMapOdd.equals(tMapOdd)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        System.out.println(isTwin("abcd", "cdab"));
        System.out.println(isTwin("abcd", "bcda"));
        System.out.println(isTwin("abc", "cba"));

    }
}

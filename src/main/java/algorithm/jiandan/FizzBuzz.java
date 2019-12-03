package algorithm.jiandan;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 *
 * 如果这个数被3整除，打印fizz.
 * 如果这个数被5整除，打印buzz.
 * 如果这个数能同时被3和5整除，打印fizz buzz.
 * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 *
 * @ClassName FizzBuzz
 * @Author will
 * @Date 2019/12/2 10:06 AM
 **/
public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean five = i % 5 == 0;
            boolean three = i % 3 == 0;
            if (five && three) {
                list.add("fizz buzz");
            } else if (three) {
                list.add("fizz");
            } else if (five) {
                list.add("buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(100));
    }
}

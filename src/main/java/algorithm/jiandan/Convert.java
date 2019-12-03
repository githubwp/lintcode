package algorithm.jiandan;

import java.util.Objects;

public class Convert {
    /*
    描述
    给两个字符串 S 和 T, 判断 S 能不能通过删除一些字母(包括0个)变成 T.

    您在真实的面试中是否遇到过这个题？
    样例
    input:
    S = "lintcode"
    T = "lint"
    output:
            true
    */

    public static boolean canConvert(String s, String t) {
        // Write your code here
        if (Objects.equals(s, t)) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        if (s.length() <= t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        int offset = 0;
        for (char c : t.toCharArray()) {
            int num = s.indexOf(c, offset);
            if (num == -1) {
                return false;
            } else {
                //能搜到
                offset = num + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConvert("babbba", "aab"));
        ;
//        System.out.println(canConvert("l1intcode", "li1nt"));;
//        System.out.println(canConvert(null, "null"));;
//        System.out.println(canConvert("adcadcadcdac", "adddaa"));;
    }
}

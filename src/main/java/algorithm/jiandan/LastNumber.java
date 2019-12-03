package algorithm.jiandan;

public class LastNumber {
    /*
    有一个01字符串str。其中只可能会出现三个单词，两个字节的单词10或者11，一个字节的单词0。返回最后1个单词的字节数。

    字符串长度不超过100000。

    您在真实的面试中是否遇到过这个题？
    样例
    Give str="100". Return 1.

    Explanation:

    Str consists of two words, 10 and 0.
    Give str="1110". Return 2.

    Explanation:
    Str consists of two words, 11 and 10.
    */

    public static int judgeTheLastNumber(String str) {
        // Write your code here
        if (str.length() == 1) {
            return 1;
        }
        String lastTwoStr = str.substring(str.length() - 2, str.length());
        if ("11".equals(lastTwoStr)) {
            return 2;
        }
        str = str.replace("11", "");
        str = str.substring(str.length() - 2, str.length());
        if ("00".equals(str)) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(judgeTheLastNumber("100"));;
        System.out.println(judgeTheLastNumber("1110"));;
        System.out.println(judgeTheLastNumber("0"));;
        System.out.println(judgeTheLastNumber("001011011"));;
        System.out.println(judgeTheLastNumber("101100001100100011010"));;
    }
}

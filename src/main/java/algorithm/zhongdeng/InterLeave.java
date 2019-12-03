package algorithm.zhongdeng;

import java.util.HashMap;
import java.util.Map;

public class InterLeave {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public static boolean isInterleave1(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        //首位相同
        if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0)) {
            return false;
        }
        //末位相同
        if (s1.charAt(s1.length() - 1) != s3.charAt(s3.length() - 1) && s2.charAt(s2.length() - 1) != s3.charAt(s3.length() - 1)) {
            return false;
        }
        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length())) || isInterleave(s1, s2.substring(1,
                    s2.length()), s3.substring(1, s3.length()));
        } else if (s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()));
        } else {
            return isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
        }
    }

    public static final Map<String, Boolean> map = new HashMap<>();

    public static void putMap(String s1, String s2, Boolean value) {
        String s1n = s1 + s2;
        String s2n = s2 + s1;
        if (!map.containsKey(s1n)) {
            map.put(s1n, value);
        }
        if (!map.containsKey(s2n)) {
            map.put(s2n, value);
        }
    }
    public static boolean isInterleave2(String s1, String s2, String s3) {
        // write your code here
        
        if (s1.length() + s2.length() != s3.length()) {
            putMap(s1,s2,false);
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        //首位相同
        if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0)) {
            return false;
        }
        //末位相同
        if (s1.charAt(s1.length() - 1) != s3.charAt(s3.length() - 1) && s2.charAt(s2.length() - 1) != s3.charAt(s3.length() - 1)) {
            return false;
        }
        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length())) || isInterleave(s1, s2.substring(1,
                    s2.length()), s3.substring(1, s3.length()));
        } else if (s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()));
        } else {
            return isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
        }
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] his = new boolean[s1.length() + 1][s2.length() + 1];
        his[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (his[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                his[i][0] = true;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (his[0][i-1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
                his[0][i] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((his[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (his[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    his[i][j] = true;
                }
            }
        }
        return his[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));//true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));//false
        System.out.println(isInterleave("", "", "1"));//false
        System.out.println(isInterleave("", "a", "a"));//true
    }
}

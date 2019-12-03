package algorithm.jiandan;

public class RepeatedSubString {

    /**
     * @param s: a string
     * @return: return a boolean
     */

    //时间复杂度O（n²/4）
    public static boolean repeatedSubstringPattern1(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) {
            return false;
        }
        int endLen = (len + 1) / 2;
        char[] charArray = s.toCharArray();
        //双指针
        int subOffset = 0;
        int offset = 1;
        int minOffset = offset;
        while (offset < len) {
            if (charArray[offset] == charArray[subOffset]) {
                //相等
                subOffset++;
                offset++;
                if (subOffset == minOffset) {
                    subOffset = 0;
                }
            } else {
                minOffset++;
                if (minOffset > endLen) {
                    return false;
                }
                offset = minOffset;
                subOffset = 0;
            }
        }
        System.out.println(offset);
        return subOffset == 0;
    }

    public static boolean repeatedSubstringPattern1Plus(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) {
            return false;
        }
        int endLen = (len + 1) / 2;
        char[] charArray = s.toCharArray();
        //双指针
        int offset = 1;
        int minOffset = offset;
        while (offset < len) {
            if (charArray[offset] == charArray[offset % minOffset]) {
                //相等
                offset++;
            } else {
                minOffset++;
                if (minOffset > endLen) {
                    return false;
                }
                offset = minOffset;
            }
        }
        return offset % minOffset == 0;
    }

    //时间复杂度O（n²/4)
    public static boolean repeatedSubstringPattern2(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) {
            return false;
        }
        int endLen = (len + 1) / 2;
        int num = 0;
        for (int i = 0; i < endLen; i++) {
            num = 0;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(num) != s.charAt(j)) {
                    break;
                } else {
                    num++;
                    if (num > i) {
                        num = 0;
                    }
                    if (j == len - 1 && num == 0) {
                        return true;
                    }
                }
            }
        }
        return num == 0;
    }

    public static boolean repeatedSubstringPattern2Plus(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) {
            return false;
        }
        int endLen = (len + 1) / 2;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < endLen; i++) {
            for (int j = i + 1, l = j; j < len; j++) {
                if (charArray[j % l] != charArray[j]) {
                    break;
                } else {
                    if (j == len - 1 && len % l == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[] getPrimeNums(int maxNum) {
        int[] primeNums = new int[maxNum / 2 + 1];
        int sqrtRoot;
        int cursor = 0;
        boolean isPrime;
        for (int i = 2; i <= maxNum; i++) {
            sqrtRoot = (int) Math.sqrt(i); //取平方根
            isPrime = true;
            for (int j = 0; j < cursor; j++) {
                if (primeNums[j] > sqrtRoot) {
                    //证明在0-平方根内没有找到因子，则一定是素数，因为如果不是素数，则必定有一个因子小于等于平方根
                    break;
                }
                if (i % primeNums[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNums[cursor++] = i;
            }
        }
        int[] result = new int[cursor];
        System.arraycopy(primeNums, 0, result, 0, cursor);
        return result;
    }
    public static int[] getPrimeNumsAddOne(int maxNum) {
        int[] primeNums = new int[maxNum / 2 + 1];
        int sqrtRoot;
        int cursor = 0;
        boolean isPrime;
        for (int i = 2; i <= maxNum; i++) {
            sqrtRoot = (int) Math.sqrt(i); //取平方根
            isPrime = true;
            for (int j = 0; j < cursor; j++) {
                if (primeNums[j] > sqrtRoot) {
                    //证明在0-平方根内没有找到因子，则一定是素数，因为如果不是素数，则必定有一个因子小于等于平方根
                    break;
                }
                if (i % primeNums[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNums[cursor++] = i;
            }
        }
        int[] result = new int[cursor+1];
        System.arraycopy(primeNums, 0, result, 1, cursor);
        result[0] = 1;
        return result;
    }

    /*
        素数=质数，只有1和本身两个因子的数
        先找到len内的所有素数,然后遍历素数
     */
    public static boolean repeatedSubstringPatternBest(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) {
            return false;
        }
        int endLen = (len + 1) / 2;
        int[] primes = getPrimeNums(endLen);
        int offset;
        boolean res = true;
        for (int prime : primes) {
            if (len % prime == 0) {
                offset = len / prime;
                res = true;
                for (int k = 0; k < offset; k++) {
                    if (!res) {
                        break;
                    }
                    for (int j = 1; j < prime; j++) {
                        if (s.charAt(k) != s.charAt(offset * j + k)) {
                            res = false;
                            break;
                        }
                    }
                }
                if (res) {
                    return true;
                }
            } else {
                res = false;
            }
        }
        if (!res) {
            for (int i = 1; i < len; i++) {
                if (s.charAt(0) != s.charAt(i)) {
                    res = false;
                    break;
                } else {
                    res = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aabaaabaaaba";
        String s1 = "abab";
        String s2 = "aba";
        String s3 = "aaaaa";
        System.out.println(repeatedSubstringPatternBest(s));
        System.out.println(repeatedSubstringPatternBest(s1));
        System.out.println(repeatedSubstringPatternBest(s2));
        System.out.println(repeatedSubstringPatternBest(s3));
    }
}

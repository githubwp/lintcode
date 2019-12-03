package algorithm.zhongdeng;

public class ValidParenthesisString {
/*
    Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid.
    We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
            '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.
    The string size will be in the range [1, 100].

    样例
    Input: "()"
    Output: True

    Input: "(*)"
    Output: True

    Input: "(*))"
    Output: True

    Input: "(****)()*((())(*)))((**()))()(**()*((*((*()(((*)((()***)(()(()))*****((()()(***"
    Output: True
*/

    public static boolean correctSpecialCharacters(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len == 0 || (len == 1 && "*".equals(s))) {
            return true;
        }

        char[] charArr = s.toCharArray();
        char[] lefts = new char[100];
        char[] rights = new char[100];
        char[] commons = new char[100];

        for (int i = 0; i < len; i++) {
            char curChar = charArr[i];
            if (curChar == '(') {
                lefts[i] = curChar;
            } else if (curChar == ')') {
                rights[i] = curChar;
            } else if (curChar == '*') {
                commons[i] = curChar;
            } else {
                return false;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (lefts[i] == '(') {
                //左有，找对应的右括号,且右括号必须在左括号之后
                for (int i1 = len - 1; i1 > i; i1--) {
                    if (rights[i1] == ')') {
                        //找到
                        rights[i1] = 0;
                        lefts[i] = 0;
                        break;
                    }
                }
                if (lefts[i] == '(') {
                    //遍历完右括号还没找到
                    for (int i1 = len - 1; i1 > i; i1--) {
                        if (commons[i1] == '*') {
                            //找到
                            commons[i1] = 0;
                            lefts[i] = 0;
                            break;
                        }
                    }
                }
                if (lefts[i] == '(') {
                    return false;
                }
            }
            if (rights[i] == ')') {
                //右有，找对应的左括号,且左括号必须在右括号之前
                for (int i1 = i; i1 >= 0; i1--) {
                    if (lefts[i1] == '(') {
                        //找到
                        lefts[i1] = 0;
                        rights[i] = 0;
                        break;
                    }
                }
                if (rights[i] == ')') {
                    //遍历完左括号还没找到
                    for (int i1 = i; i1 >= 0; i1--) {
                        if (commons[i1] == '*') {
                            //找到
                            commons[i1] = 0;
                            rights[i] = 0;
                            break;
                        }
                    }
                }
                if (rights[i] == ')') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution(String s) {
        char[] chars = s.toCharArray();
        //(,40;),41;*,42
        int l = 0, lx = 0;
        for (char c : chars) {
            if (c == 40) {
                l++;
                lx++;
            } else if (c == 42) {
                if (l > 0) {
                    l--;
                }
                lx++;
            } else {
                if (l > 0) {
                    l--;
                }
                lx--;
                if (lx < 0) {
                    return false;
                }
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution("()"));
        System.out.println(solution("(*)"));
        System.out.println(solution("(*))"));
        System.out.println(solution("((*)"));
        System.out.println(solution("(*))*)(("));//false
        System.out.println(solution("(*)(**(*))*(*)()**(*)*)())()()*()**()**)*****)*)(((()(((()**)((**)()*((*(*))*))((())**)(()*("));//false
        System.out.println(solution("(****)()*((())(*)))((**()))()(**()*((*((*()(((*)((()***)(()(()))*****((()()(***"));
        System.out.println(System.currentTimeMillis() - start);
    }
}

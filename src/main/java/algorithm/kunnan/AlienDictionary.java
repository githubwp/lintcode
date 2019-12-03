package algorithm.kunnan;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {
    /*
    描述
    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list
    of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order
    of letters in this language.

    You may assume all letters are in lowercase.
    You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return the smallest in lexicographical order

    样例
    Given the following words in dictionary,

[
        "wrt",
        "wrf",
        "er",
        "ett",
        "rftt"
        ]
    The correct order is: "wertf"

    Given the following words in dictionary,

[
        "z",
        "x"
        ]
    The correct order is: "zx".
    */

    public static List<List<String>> firstLetter(List<List<String>> allRule, List<String> words) {
        if (words.size() > 1) {
            //0个或者一个单词比较的话，没有意义
            LinkedHashMap<String, List<String>> firstLetterGroup = words.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1),
                    LinkedHashMap::new, Collectors.toList()));
            List<String> rule = new ArrayList<>();
            firstLetterGroup.forEach((s, strings) -> {
                rule.add(s);
                firstLetter(allRule, strings.stream().filter(s1 -> s1.length() > 1).map(s1 -> s1.substring(1, s1.length())).collect
                        (Collectors.toList()));
            });
            if (rule.size() > 1) {
                //只有1个的数据没有顺序的关系，没有意义
                allRule.add(rule);
            }
        }
        return allRule;
    }

//    public static List<List<String>> merge(List<List<String>> allRule) {
//
//    }


    public static String alienOrder(String[] words) {
        // Write your code here

        List<String> wordsList = Arrays.asList(words);
        List<List<String>> allRule = firstLetter(new ArrayList<>(), wordsList);
        //转换为List<Tree>
        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < allRule.size(); i++) {
            List<String> list = allRule.get(i);
            for (int i1 = 0; i1 < list.size(); i1++) {
                String s = list.get(i1);
                Tree tree = new Tree(s);
                if (i1 > 0) {
                    tree.getL().add(new Tree(list.get(i1 - 1)));
                }
                if (i1 < list.size() - 1) {
                    tree.getR().add(new Tree(list.get(i1 + 1)));
                }
                trees.add(tree);
            }
        }

        //将Trees多个元素整合成一个元素的Tree，若整合不成，则return ""


        System.out.println(allRule);
        return "";
    }

    public void mergeTrees(List<Tree> trees) {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            for (int i1 = 0; i1 < trees.size(); i1++) {
                if (i == i1) {
                    continue;
                }
                Tree innerTree = trees.get(i);

            }
        }
    }

    public boolean mergeTwoTree(Tree t1, Tree t2) {
        if (t1.getC() == t2.getC()) {
            t1.getL().addAll(t2.getL());
            t1.getR().addAll(t2.getR());
        } else{

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));
        System.out.println(alienOrder(new String[]{"z",
                "x"}));
    }
}

class Tree {
    List<Tree> l = new ArrayList<>();
    private String c;
    List<Tree> r = new ArrayList<>();

    private Tree() {
    }

    Tree(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public List<Tree> getL() {
        return l;
    }

    public void setL(List<Tree> l) {
        this.l = l;
    }




    public List<Tree> getR() {
        return r;
    }

    public void setR(List<Tree> r) {
        this.r = r;
    }
}

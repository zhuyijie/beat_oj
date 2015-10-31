package com.baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1002 {

    private static final Map<Character, Integer> char2Int;

    static {
        Object[][] maps = new Object[][] {
                {1, "ij"}, {2, "abc"},
                {3, "def"}, {4, "gh"},
                {5, "kl"}, {6, "mn"},
                {7, "prs"}, {8, "tuv"},
                {9, "wxy"}, {0, "oqz"}
        };
        char2Int = new HashMap<>();
        for (Object[] map : maps) {
            Integer num = (Integer) map[0];
            String chars = (String) map[1];
            for (int i = 0; i < chars.length();i++) {
                char2Int.put(chars.charAt(i), num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            String num = scanner.nextLine();
            if (num.charAt(0) == '-') {
                break;
            }
            int numOfWords = scanner.nextInt();
            String[] words = new String[0];
            for (int i = 0;i < numOfWords;i++) {
                words[i] = scanner.nextLine();
            }
        } while (true);
    }

    public List<String> solve(String num, String[] words) {
        List[] dict = new List[26];
        for (String word : words) {
            int index = word.charAt(0) - 'a';
            if (dict[index] == null) {
                dict[index] = new ArrayList<>();
            }
            dict[index].add(word);
        }
        return dfs(num, dict);
    }

    public List<String> dfs(String num, List<String>[] dict) {
        if (num.isEmpty()) {
            return Collections.emptyList();
        }
        int index = num.charAt(0) - 'a';
        if (dict[index] == null) return null;
        
        for (String candidate : dict[index]) {
            if (num.startsWith(candidate)) {

            }
        }
    }
}

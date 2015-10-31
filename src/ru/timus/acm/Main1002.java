package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main1002 {

    private static final Map<Character, Character> char2Num;

    static {
        Object[][] maps = new Object[][] {
                {'1', "ij"}, {'2', "abc"},
                {'3', "def"}, {'4', "gh"},
                {'5', "kl"}, {'6', "mn"},
                {'7', "prs"}, {'8', "tuv"},
                {'9', "wxy"}, {'0', "oqz"}
        };
        char2Num = new HashMap<>();
        for (Object[] map : maps) {
            Character num = (Character) map[0];
            String chars = (String) map[1];
            for (int i = 0; i < chars.length();i++) {
                char2Num.put(chars.charAt(i), num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        do {
            String num = in.readLine();
            if (num.charAt(0) == '-') {
                break;
            }
            int numOfWords = Integer.valueOf(in.readLine());
            String[] words = new String[numOfWords];
            String[] translated = new String[numOfWords];
            for (int i = 0;i < numOfWords;i++) {
                words[i] = in.readLine();
                translated[i] = translate(words[i]);
            }
            String[] answer = dp(num, words, translated);
            if (answer == null) {
                out.println("No solution.");
            } else {
                int size = answer.length;
                for (int i = 0;i < size;i++) {
                    if (i != 0) {
                        out.print(" ");
                    }
                    out.print(answer[i]);
                }
                out.println();
            }
        } while (true);
        out.flush();
    }

    public static String translate(String word) {
        char[] nums = new char[word.length()];
        for (int i = 0;i < word.length();i++) {
            nums[i] = char2Num.get(word.charAt(i));
        }
        return new String(nums);
    }


    /**
     *
     * dp the result, remember to reverse it
     *
     * */
    public static String[] dp(String num, String[] dict, String[] translated) {
        int[] optimal = new int[101];
        Arrays.fill(optimal, Integer.MAX_VALUE - 1);
        optimal[0] = 0;
        String[] optimalValue = new String[101];

        for(int i = 1;i <= num.length();i++) {
            for (int j = 0;j < dict.length;j++) {
                int l = translated[j].length();
                if (l <= i && optimal[i - l] + 1 < optimal[i] && num.substring(i - l, i).equals(translated[j])) {
                    optimal[i] = optimal[i - l] + 1;
                    optimalValue[i] = dict[j];
                }
            }
        }
        if (optimal[num.length()] == Integer.MAX_VALUE - 1) {
            return null;
        } else {
            int resultSize = optimal[num.length()];
            String[] result = new String[resultSize];
            int pivot = num.length();
            int resultPivot = resultSize - 1;
            while (optimal[pivot] > 0 && resultPivot >= 0) {
                result[resultPivot] = optimalValue[pivot];
                pivot = pivot - optimalValue[pivot].length();
                resultPivot--;
            }
            return result;
        }
    }
}

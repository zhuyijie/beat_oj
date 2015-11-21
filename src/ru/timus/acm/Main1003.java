package ru.timus.acm;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1003 Parity
 *
 * @author mojie
 * @since 10/31 0031
 */
public class Main1003 {

    public static void main(String[] args) throws Exception {
        new Main1003().run();
    }

    BufferedReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        solve();
    }

    void solve() throws IOException {
        outer:
        while (true) {
            int length = Integer.valueOf(in.readLine());
            if (length == -1) break;
            int numOfQuestions = Integer.valueOf(in.readLine());
            Map<Integer, Entry> recordMap = new HashMap<>(numOfQuestions * 2);
            String[] questions = new String[numOfQuestions];
            for (int i = 0; i < numOfQuestions; i++) {
                questions[i] = in.readLine();
            }
            main:
            for (int i = 0; i < numOfQuestions; i++) {
                String iLine = questions[i];
                String[] tokens = iLine.split(" ");
                int begin = Integer.valueOf(tokens[0]);
                int end = Integer.valueOf(tokens[1]);
                boolean odd = tokens[2].equals("odd");
                while (recordMap.containsKey(begin)) {
                    Entry e = recordMap.get(begin);
                    if (end == e.end) {
                        if (odd == e.odd) {continue main;} else {out.println(i);continue outer;}
                    } else if (end > e.end) {
                        begin = e.end + 1;
                        odd = odd ^ e.odd;
                    } else {
                        // hold the origin value
                        int eend = e.end;
                        boolean eodd = e.odd;
                        e.end = end;
                        e.odd = odd;
                        begin = e.end + 1;
                        end = eend;
                        odd = eodd ^ e.odd;
                    }
                }
                recordMap.put(begin, new Entry(end, odd));
            }
        }
        out.flush();
    }

    static class Entry {
        int begin;
        int end;
        boolean odd;

        public Entry(int end, boolean odd) {
            this.end = end;
            this.odd = odd;
        }
    }
}

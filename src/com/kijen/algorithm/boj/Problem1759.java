package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 1759. 암호 만들기 */
public class Problem1759 {
    static int L, C;
    static char[] c;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1759.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = new char[C];

        for (int i = 0; i < C; i++) {
            c[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(c);

        combi(0, 0, new StringBuilder());

        br.close();
    }

    static void combi(int depth, int len,StringBuilder sb) {
        if (len == L) {
            String result = sb.toString();

            if (check(result)) {
                System.out.println(result);
            }

            return;
        }

        if (depth == C) {
            return;
        }

        combi(depth + 1, len + 1, sb.append(c[depth]));
        sb.deleteCharAt(sb.length() - 1);
        combi(depth + 1, len, sb);

    }

    static boolean check(String s) {
        int vo = 0;
        int con = 0;

        L : for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            for (int vowel : vowels) {
                if (c == vowel) {
                    vo++;
                    continue L;
                }
            }

            con++;
        }

        if (vo >= 1 && con >= 2) {
            return true;
        }

        return false;
    }
}

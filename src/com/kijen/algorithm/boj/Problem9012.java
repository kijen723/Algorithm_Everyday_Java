package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* BOJ 9012. 괄호 */
public class Problem9012 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input9012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Deque<Character> dq = new ArrayDeque<>();
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (dq.isEmpty()) {
                    dq.offerLast(c);

                    if (c == ')') {
                        break;
                    }
                } else if (c == ')') {
                    dq.pollLast();
                } else {
                    dq.offerLast(c);
                }
            }

            if (dq.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        br.close();
    }
}

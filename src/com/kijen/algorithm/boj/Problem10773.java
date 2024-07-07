package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* BOJ 10773. 제로 */
public class Problem10773 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input10773.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n != 0) {
                dq.offerLast(n);
            } else {
                dq.pollLast();
            }
        }

        int answer = 0;
        int cnt = dq.size();

        for (int i = 0; i < cnt; i++) {
            answer += dq.pollLast();
        }

        System.out.println(answer);

        br.close();
    }
}

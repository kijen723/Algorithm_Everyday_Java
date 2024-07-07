package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* BOJ 28278. 스택 2 */
public class Problem28278 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input28278.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            } else if (cmd == 2) {
                if (!dq.isEmpty()) {
                    sb.append(dq.pollLast()).append("\n");
                } else {
                    sb.append(-1 + "\n");
                }
            } else if (cmd == 3) {
                sb.append(dq.size()).append("\n");
            } else if (cmd == 4) {
                if (!dq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(1 + "\n");
                }
            } else if (cmd == 5) {
                if (!dq.isEmpty()) {
                    sb.append(dq.peekLast()).append("\n");
                } else {
                    sb.append(-1 + "\n");
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}

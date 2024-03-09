package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 1158. 요세푸스 문제 */
public class Problem1158 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1158.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> answer = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            answer.offer(queue.poll());
        }

        System.out.print("<");

        while (!answer.isEmpty()) {
            System.out.print(answer.poll());

            if (!answer.isEmpty()) {
                System.out.print(", ");
            }
        }

        System.out.println(">");

        br.close();
    }
}

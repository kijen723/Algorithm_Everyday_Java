package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* BOJ 2023. 신기한 소수 */
public class Problem2164 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2164.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> cardQueue = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            cardQueue.offer(i);
        }

        while (cardQueue.size() > 1) {
            cardQueue.poll();
            cardQueue.offer(cardQueue.poll());
        }

        System.out.println(cardQueue.peek());

        br.close();
    }
}

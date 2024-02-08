package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* BOJ 11286. 절댓값 힙 */
public class Problem11286 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11286.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) != Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            } else {
                return o1 - o2;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                queue.offer(x);
            }
        }

        br.close();
    }
}

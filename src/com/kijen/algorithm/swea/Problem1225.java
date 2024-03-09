package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* SWEA 1225. [S/W 문제해결 기본] 7일차 - 암호생성기 */
public class Problem1225 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1225.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag;
        int tc;
        String[] numbers;
        Queue<Integer> queue;

        for (int t = 0; t < 10; t++) {
            flag = false;
            tc = Integer.parseInt(br.readLine());
            numbers = br.readLine().split(" ");
            queue = new ArrayDeque<>();

            for (String str : numbers) {
                queue.offer(Integer.parseInt(str));
            }

            while (!flag) {
                for (int i = 1; i < 6; i++) {
                    if (queue.peek() - i > 0) {
                        queue.offer(queue.poll() - i);
                    } else {
                        queue.poll();
                        queue.offer(0);
                        flag = true;

                        break;
                    }
                }
            }

            System.out.print("#" + tc + " ");

            for (Integer n : queue) {
                System.out.print(n + " ");
            }

            System.out.println();
        }

        br.close();
    }
}

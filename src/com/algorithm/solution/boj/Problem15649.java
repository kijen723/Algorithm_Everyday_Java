package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 15649. N과 M (1) */
public class Problem15649 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input15649.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        check = new boolean[N + 1];

        recursive(0);

        br.close();
    }

    private static void recursive(int n) {
        if (n >= M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }

            System.out.println();

            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[n] = i;
                recursive(n + 1);
                check[i] = false;
            }
        }
    }
}

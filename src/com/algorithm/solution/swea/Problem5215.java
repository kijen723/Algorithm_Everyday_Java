package com.algorithm.solution.swea;

import java.io.FileInputStream;
import java.util.Scanner;

/* SWEA 5215. 햄버거 다이어트 */
public class Problem5215 {
    static int N = 0, L = 0, answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5215.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            L = sc.nextInt();

            answer = 0;
            arr = new int[N][2];

            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            dfs(0, 0, 0);

            System.out.printf("#%d %d\n", test_case, answer);
        }

        sc.close();
    }

    static void dfs(int n, int score, int cal) {
        if (cal > L) {

            return;
        }

        if (n == N) {
            if (answer < score) {
                answer = score;
            }

            return;
        }

        dfs(n + 1, score + arr[n][0], cal + arr[n][1]);
        dfs(n + 1, score, cal);
    }
}

package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* SWEA 1210. [S/W 문제해결 기본] 2일차 - Ladder1 */
public class Problem1210 {
    static int[][] dirs = {{0, -1}, {0, 1}};
    static int[][] ladder = new int[100][100];
    static boolean[][] check = new boolean[100][100];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1210.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc < 11; tc++) {
            int n = Integer.parseInt(br.readLine());
            int start = 0;

            for (int i = 0; i < 100; i++) {
                String[] input = br.readLine().split(" ");

                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(input[j]);

                    if (ladder[i][j] == 2) {
                        start = j;
                    }
                }
            }

            check = new boolean[100][100];
            int answer = go(99, start);

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static int go(int i, int j) {
        if (i == 0) {
            return j;
        }

        for (int[] dir : dirs) {
            if (j + dir[1] >= 0 && j + dir[1] < 100 && !check[i][j + dir[1]] && ladder[i][j + dir[1]] == 1) {
                check[i][j] = true;

                return go(i, j + dir[1]);
            }
        }

        return go(i - 1, j);
    }
}

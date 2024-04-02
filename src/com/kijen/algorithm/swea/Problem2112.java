package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* SWEA 2112. [모의 SW 역량테스트] 보호 필름 */
public class Problem2112 {
    static int D, W, K, answer;
    static int[] subset;
    static int[][] film;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for (int r = 0; r < D; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < W; c++) {
                    film[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;

            if (checkPass(film)) {
                answer = -1;
            }

            for (int i = 1; i <= D; i++) {
                if (answer != 0) {
                    break;
                }

                subset = new int[D];
                Arrays.fill(subset, -1);

                getSubset(0, i, 0);
            }

            System.out.println("#" + tc + " " + (answer == -1 ? 0 : answer));
        }

        br.close();
    }

    static void getSubset(int depth, int n, int start) {
        if (answer != 0) {
            return;
        }

        if (depth == n) {
            if (checkPass(copyAndFill())) {
                answer = n;
            }

            return;
        }

        for (int i = start; i < D; i++) {
            for (int j = 0; j < 2; j++) {
                subset[i] = j;
                getSubset(depth + 1, n, i + 1);
            }

            subset[i] = -1;
        }
    }

    static int[][] copyAndFill() {
        int[][] result = new int[D][W];

        for (int r = 0; r < D; r++) {
            if (subset[r] == -1) {
                for (int c = 0; c < W; c++) {
                    result[r][c] = film[r][c];
                }
            } else {
                for (int c = 0; c < W; c++) {
                    result[r][c] = subset[r];
                }
            }
        }

        return result;
    }

    static boolean checkPass(int[][] film) {
        L : for (int c = 0; c < W; c++) {
            int cnt = 1;
            int check = film[0][c];

            for (int r = 1; r < D; r++) {
                if (check == film[r][c]) {
                    cnt++;
                } else {
                    cnt = 1;
                    check = film[r][c];
                }

                if (cnt == K) {
                    continue L;
                }
            }

            return false;
        }

        return true;
    }
}

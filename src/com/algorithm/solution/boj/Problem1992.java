package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 1992. 쿼드트리 */
public class Problem1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] video;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1992.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        String[] input;

        for (int r = 0; r < N; r++) {
            input = br.readLine().split("");

            for (int c = 0; c < N; c++) {
                video[r][c] = Integer.parseInt(input[c]);
            }
        }

        quadTree(0, 0, N);

        System.out.println(sb);

        br.close();
    }

    private static void quadTree(int r, int c, int n) {
        if (checkSame(r, c, n)) {
            sb.append(video[r][c]);
        } else {
            if (n == 2) {
                sb.append("(");
                sb.append(video[r][c]);
                sb.append(video[r][c + 1]);
                sb.append(video[r + 1][c]);
                sb.append(video[r + 1][c + 1]);
                sb.append(")");
            } else {
                sb.append("(");
                quadTree(r, c, n / 2);
                quadTree(r, c + (n / 2), n / 2);
                quadTree(r + (n / 2), c,  n / 2);
                quadTree(r + (n / 2), c + (n / 2), n / 2);
                sb.append(")");
            }
        }
    }

    private static boolean checkSame(int r, int c, int n) {
        int temp = video[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (video[i][j] != temp) return false;
            }
        }

        return true;
    }
}

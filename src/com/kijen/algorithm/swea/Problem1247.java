package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* SWEA 1247. [S/W 문제해결 응용] 3일차 - 최적 경로 */
public class Problem1247 {
    static int N;
    static int answer;
    static int[] cop = new int[2];
    static int[] home = new int[2];
    static int[][] cus;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            cus = new int[N][2];
            check = new boolean[N];
            answer = Integer.MAX_VALUE;

            cop[0] = Integer.parseInt(input[0]);
            cop[1] = Integer.parseInt(input[1]);
            home[0] = Integer.parseInt(input[2]);
            home[1] = Integer.parseInt(input[3]);

            int idx = 0;

            for (int i = 4; i < input.length; i++) {
                cus[idx][0] = Integer.parseInt(input[i]);
                cus[idx++][1] = Integer.parseInt(input[++i]);
            }

            delivery(0, 0, cop);

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static void delivery(int idx, int len, int[] coo) {
        if (idx >= N) {
            answer = Math.min(answer, len + (Math.abs(coo[0] - home[0]) + Math.abs(coo[1] - home[1])));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                delivery(idx + 1, len + (Math.abs(coo[0] - cus[i][0]) + Math.abs(coo[1] - cus[i][1])), cus[i]);
                check[i] = false;
            }
        }
    }
}
package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 2166. 다각형의 면적 */
public class Problem2166 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2166.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] matrix = new long[N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Long.parseLong(st.nextToken());
            matrix[i][1] = Long.parseLong(st.nextToken());
        }

        matrix[N][0] = matrix[0][0];
        matrix[N][1] = matrix[0][1];

        long a = 0;
        long b = 0;

        for (int i = 0; i < N; i++) {
            a += matrix[i][0] * matrix[i + 1][1];
            b += matrix[i][1] * matrix[i + 1][0];
        }

        double answer = (double) Math.abs(a - b) / 2;

        System.out.printf("%.1f", answer);

        br.close();
    }
}

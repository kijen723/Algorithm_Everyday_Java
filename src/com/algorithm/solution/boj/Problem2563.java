package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 2563. 색종이 */
public class Problem2563 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2563.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] paper = new boolean[100][100];

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = true;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}

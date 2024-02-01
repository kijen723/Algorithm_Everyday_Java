package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 11660. 구간 합 구하기 5 */
public class Problem11660 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11660.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] numbers = new int[N + 1][N + 1];

        for (int i = 1; i < numbers.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <numbers[i].length; j++) {
                numbers[i][j] = numbers[i - 1][j] + numbers[i][j - 1] + Integer.parseInt(st.nextToken()) - numbers[i - 1][j - 1];
            }
        }

        for (int c = 0; c < M; c++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(numbers[x2][y2] - numbers[x2][y1 -1] - numbers[x1 - 1][y2] + numbers[x1 -1][y1 - 1]);
        }

        br.close();
    }
}

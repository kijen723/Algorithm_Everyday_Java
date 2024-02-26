package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 17070. 파이프 옮기기 1 */
public class Problem17070 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17070.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }





        br.close();
    }
}

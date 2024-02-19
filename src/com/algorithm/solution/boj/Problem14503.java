package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 14503. 로봇 청소기 */
public class Problem14503 {
    static int N, M, R, C, dic, answer = 0;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input14503.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dic = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int nr, nc;

        while (true) {
            if (map[R][C] == 0) {
                map[R][C] = -1;
                answer++;
            } else if (checkDust()) {
                while (true) {
                    dic = (dic - 1 + 4) % 4;
                    nr = R + dir[dic][0];
                    nc = C + dir[dic][1];

                    if (map[nr][nc] == 0) {
                        R = nr;
                        C = nc;

                        break;
                    }
                }
            } else {
                nr = R - dir[dic][0];
                nc = C - dir[dic][1];

                if (map[nr][nc] < 1) {
                    R = nr;
                    C = nc;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static boolean checkDust() {
        int nr, nc;

        for (int d = 0; d < dir.length; d++) {
            nr = R + dir[d][0];
            nc = C + dir[d][1];

            if (map[nr][nc] == 0) return true;
        }

        return false;
    }
}

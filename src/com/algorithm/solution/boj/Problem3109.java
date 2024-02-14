package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 3109. 빵집 */
public class Problem3109 {
    static int R, C, temp, answer;
    static boolean flag;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input3109.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        String[] input;

        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");

            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
            }
        }

        for (int r = 0; r < R; r++) {
            flag = false;
            getPipe(r, 0);
        }

        System.out.println(answer);

        br.close();
    }

    private static void getPipe(int r, int c) {
        if (c == C - 1) {
            answer++;
            flag = true;

            return;
        }

        int nr, nc;

        for (int d = 0; d < dir.length; d++) {
            nr = r + dir[d][0];
            nc = c + dir[d][1];

            if (nr >= 0 && nr < R && nc < C) {
                if (map[nr][nc].equals(".") && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    getPipe(nr, nc);
                    if (flag) return;
                }
            }
        }
    }
}

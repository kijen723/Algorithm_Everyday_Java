package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 1520. 내리막 길 */
public class Problem1520 {
    static int R, C;
    static int[][] map, mem, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int dfs(int r, int c) {
        if (r == R - 1 && c == C - 1) {
            return 1;
        }

        if (mem[r][c] != Integer.MIN_VALUE) {
            return mem[r][c];
        }

        int cnt = 0;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (map[nr][nc] >= map[r][c]) {
                continue;
            }

            cnt += dfs(nr, nc);
        }

        mem[r][c] = cnt;

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1520.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        mem = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                mem[r][c] = Integer.MIN_VALUE;
            }
        }

        System.out.println(dfs(0, 0));

        br.close();
    }
}

package com.kijen.algorithm.boj;

import java.io.*;
import java.util.*;

/* BOJ 4485. 녹색 옷 입은 애가 젤다지? */
public class Problem4485 {
    static class Pos {
        int r, c, m;

        Pos(int r, int c, int m) {
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input4485.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int tc = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] map = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] min = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    min[r][c] = Integer.MAX_VALUE;
                }
            }

            min[0][0] = map[0][0];
            PriorityQueue<Pos> pq = new PriorityQueue<>((a, b) -> a.m - b.m);
            pq.offer(new Pos(0, 0, map[0][0]));

            while (!pq.isEmpty()) {
                Pos p = pq.poll();

                if (p.r == N - 1 && p.c == N - 1) {
                    break;
                }

                for (int[] d : dir) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    if (min[nr][nc] <= p.m + map[nr][nc]) {
                        continue;
                    }

                    min[nr][nc] = p.m + map[nr][nc];
                    pq.offer(new Pos(nr, nc, p.m + map[nr][nc]));
                }
            }

            System.out.println("Problem " + tc++ + ": " + min[N - 1][N - 1]);

        }

        br.close();
    }
}

package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/* SWEA 4193. 수영대회 결승전 ( 완전 탐색 + 구현 ) */
public class Problem4193 {
    static class Pos {
        int r, c, t;

        Pos(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input4193.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[] start = new int[2];
            int[] end = new int[2];
            boolean[][] visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            int answer = -1;
            ArrayDeque<Pos> queue = new ArrayDeque<>();

            queue.offer(new Pos(start[0], start[1], 0));

            while (!queue.isEmpty()) {
                Pos p = queue.poll();

                if (p.r == end[0] && p.c == end[1]) {
                    answer = p.t;
                    break;
                }

                for (int[] d : dir) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
                        continue;
                    }

                    if (map[nr][nc] == 1) {
                        continue;
                    }

                    if (map[nr][nc] == 2) {
                        if (p.t % 3 == 2) {
                            visited[nr][nc] = true;
                            queue.offer(new Pos(nr, nc, p.t + 1));
                        } else {
                            visited[p.r][p.c] = true;
                            queue.offer(new Pos(p.r, p.c, p.t + 1));
                        }
                    } else {
                        visited[nr][nc] = true;
                        queue.offer(new Pos(nr, nc, p.t + 1));
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }
}

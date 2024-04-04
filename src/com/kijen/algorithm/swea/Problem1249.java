package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* SWEA 1249. [S/W 문제해결 응용] 4일차 - 보급로 */
public class Problem1249 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int r = 0; r < N; r++) {
                String str = br.readLine();

                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c) - 48;
                }
            }

            int answer = 0;
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.offer(new int[] {0, 0, 0});
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                int[] p = pq.poll();

                if (p[0] == N - 1 && p[1] == N - 1) {
                    answer = p[2];
                    break;
                }

                for (int[] d : dir) {
                    int nr = p[0] + d[0];
                    int nc = p[1] + d[1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;

                    pq.offer(new int[] {nr, nc, p[2] + map[nr][nc]});
                }
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }
}

package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 2206. 벽 부수고 이동하기 */
public class Problem2206 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2206.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        String input;

        for (int r = 0; r < N; r++) {
            input = br.readLine();

            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c) - 48;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0, 1});
        int nr, nc, answer = -1;
        int[] cur;
        visited[0][0][0] = true;
        visited[1][0][0] = true;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                answer = cur[3];
                break;
            }

            for (int d = 0; d < dir.length; d++) {
                nr = cur[0] + dir[d][0];
                nc = cur[1] + dir[d][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (cur[2] == 0) {
                    if (!visited[0][nr][nc] && map[nr][nc] == 0) {
                        visited[0][nr][nc] = true;
                        queue.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
                    } else if (map[nr][nc] == 1) {
                        visited[1][nr][nc] = true;
                        queue.offer(new int[] {nr, nc, 1, cur[3] + 1});
                    }
                } else {
                    if(!visited[1][nr][nc] && map[nr][nc] == 0) {
                        visited[1][nr][nc] = true;
                        queue.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
                    }
                }

                if (!visited[0][nr][nc] && map[nr][nc] == 0) {

                } else if (!visited[1][nr][nc] && cur[2] == 0) {
                    visited[1][nr][nc] = true;
                    queue.offer(new int[] {nr, nc, 1, cur[3] + 1});
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}

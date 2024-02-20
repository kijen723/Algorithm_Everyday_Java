package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA 5644. [모의 SW 역량테스트] 무선 충전 */
public class Problem5644 {
    static int[][] AP;
    static int[][][] map;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[][] user = new int[2][M];
            AP = new int[A][4];
            map = new int[11][11][9];

            int answer = 0;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    user[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 4; j++) {
                    AP[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            createMap();

            for (int t = 0; t < M; t++) {

            }

            System.out.println("#" + tc + " ");
        }

        br.close();
    }

    private static void createMap() {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] bc : AP) {
            boolean[][] visited = new boolean[11][11];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {bc[1], bc[0], 0});
            map[bc[1]][bc[0]][++map[bc[1]][bc[0]][0]] = bc[3];
            visited[bc[1]][bc[0]] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int[] d : dir) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];

                    if (nr > 0 && nr < 11 && nc > 0 && nc < 11 && !visited[nr][nc] && cur[2] < bc[2]) {
                        visited[nr][nc] = true;
                        map[nr][nc][++map[nr][nc][0]] = bc[3];
                        queue.offer(new int[] {nr, nc, cur[2] + 1});
                    }
                }
            }
        }
    }
}

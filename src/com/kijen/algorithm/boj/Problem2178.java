package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 2178. 미로 탐색 */
public class Problem2178 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2178.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];
        int[][] maze = new int[N][M];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        String[] inputStr;

        for (int i = 0; i < N; i++) {
            inputStr = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        int nn, nm;
        int[] coord;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            coord = queue.poll();

            if (coord[0] == N - 1 && coord[1] == M - 1) {
                System.out.println(coord[2] + 1);

                break;
            }

            for (int i = 0; i < 4; i++) {
                nn = coord[0] + dir[i][0];
                nm = coord[1] + dir[i][1];

                if (nn >= 0 && nn < N && nm >= 0 && nm < M
                        && maze[nn][nm] == 1 && !visited[nn][nm]) {
                    queue.offer(new int[] {nn, nm, coord[2] + 1});
                    visited[nn][nm] = true;
                }
            }
        }

        br.close();
    }
}

// dfs
/*
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] maze;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input2178.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] inputStr;
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            inputStr = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];

        dfs(0, 0, 0, visited);

        System.out.println(answer + 1);

        br.close();
    }

    private static void dfs(int n, int m, int cnt, boolean[][] visited) {
        if (n == N - 1 && m == M - 1) {
            answer = Math.min(answer, cnt);

            return;
        }

        visited[n][m] = true;

        for (int i = 0; i < 4; i++) {
            int nn = n + dir[i][0];
            int nm = m + dir[i][1];

            if (nn >= 0 && nn < N && nm >= 0 && nm < M
                    && maze[nn][nm] == 1 && !visited[nn][nm]) {
                dfs(nn, nm, cnt + 1, visited);
            }
        }

        visited[n][m] = false;
    }
}
 */


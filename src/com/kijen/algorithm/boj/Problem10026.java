package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* BOJ 10026. 적록색약 */
public class Problem10026 {
    static int N;
    static int[][] picture, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input10026.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new int[N][N];

        int color;
        String input;

        for (int r = 0; r < N; r++) {
            input = br.readLine();

            for (int c = 0; c < N; c++) {
                if (input.charAt(c) == 'R') color = 0;
                else if (input.charAt(c) == 'G') color = 1;
                else color = 2;

                picture[r][c] = color;
            }
        }

        System.out.println(all() + " " + rg());

        br.close();
    }

    private static int all() {
        int nr, nc, cnt = 0;
        int[] cur;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) continue;

                cnt++;
                visited[r][c] = true;
                queue.offer(new int[] {r, c, picture[r][c]});

                while (!queue.isEmpty()) {
                    cur = queue.poll();

                    for (int d = 0; d < dir.length; d++) {
                        nr = cur[0] + dir[d][0];
                        nc = cur[1] + dir[d][1];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && picture[nr][nc] == cur[2]) {
                            visited[nr][nc] = true;
                            queue.offer(new int[] {nr, nc, cur[2]});
                        }
                    }
                }
            }
        }

        return cnt;
    }

    private static int rg() {
        int nr, nc, cnt = 0;
        int[] cur;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) continue;

                cnt++;
                visited[r][c] = true;
                queue.offer(new int[] {r, c, picture[r][c]});

                while (!queue.isEmpty()) {
                    cur = queue.poll();

                    for (int d = 0; d < dir.length; d++) {
                        nr = cur[0] + dir[d][0];
                        nc = cur[1] + dir[d][1];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                            if ((cur[2] == 0 | cur[2] == 1) & (picture[nr][nc] == 0 | picture[nr][nc] == 1)) {
                                visited[nr][nc] = true;
                                queue.offer(new int[] {nr, nc, cur[2]});
                            } else if (cur[2] == 2 && picture[nr][nc] == 2) {
                                visited[nr][nc] = true;
                                queue.offer(new int[] {nr, nc, cur[2]});
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}

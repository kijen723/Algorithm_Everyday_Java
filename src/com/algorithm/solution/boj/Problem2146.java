package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 2146. 다리 만들기 */
public class Problem2146 {
    static boolean[][] visited;
    static int N, nr, nc, answer = Integer.MAX_VALUE;
    static int[] cur;
    static int[][] map, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2146.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < map.length; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        getIsland();

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (map[r][c] > 1) {
                    getMinBridge(r, c, map[r][c]);
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void getIsland() {
        int num = 0;
        queue.clear();

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (map[r][c] == 1) {
                    map[r][c] += ++num;
                    queue.offer(new int[] {r, c});

                    while (!queue.isEmpty()) {
                        cur = queue.poll();

                        for (int d = 0; d < dir.length; d++) {
                            nr = cur[0] + dir[d][0];
                            nc = cur[1] + dir[d][1];

                            if (checkRange(nr, nc, map.length, map[0].length) && map[nr][nc] == 1) {
                                map[nr][nc] += num;
                                queue.offer(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }
    }

    private static void getMinBridge(int r, int c, int n) {
        int cnt = 0;
        visited = new boolean[N][N];
        queue.clear();
        queue.offer(new int[] {r, c, cnt});
        visited[r][c] = true;

        L: while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur[2] > answer) break;

            for (int d = 0; d < dir.length; d++) {
                nr = cur[0] + dir[d][0];
                nc = cur[1] + dir[d][1];

                if (checkRange(nr, nc, map.length, map[0].length) && !visited[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc, cur[2] + 1});
                    } else if (map[nr][nc] != n) {
                        answer = cur[2];

                        break L;
                    }
                }
            }
        }
    }

    private static boolean checkRange(int r, int c, int R, int C) {
        if (r < 0 || r >= R || c < 0 || c >= C) return false;

        return true;
    }
}

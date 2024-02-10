package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 4693. 섬의 개수 */
public class Problem4693 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input4693.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int w, h, nr, nc, answer;
        boolean[][] visited;
        int[] cur;
        int[][] map;
        int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = 0;
            visited = new boolean[h][w];
            map = new int[h][w];
            queue.clear();

            if (w == 0 && h == 0) break;

            for (int r = 0; r < map.length; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < map[r].length; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map[r].length; c++) {
                    if (map[r][c] != 0 && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.offer(new int[] {r, c});

                        while (!queue.isEmpty()) {
                            cur = queue.poll();

                            for (int d = 0; d < dir.length; d++) {
                                nr = cur[0] + dir[d][0];
                                nc = cur[1] + dir[d][1];

                                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[nr].length
                                        && map[nr][nc] == 1 && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    queue.offer(new int[] {nr, nc});
                                }
                            }
                        }

                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}

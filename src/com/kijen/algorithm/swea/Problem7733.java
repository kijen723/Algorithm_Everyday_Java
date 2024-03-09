package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA 7733. 치즈 도둑 */
public class Problem7733 {
    static int N;
    static boolean[][] visited;
    static int[][] cheese, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input7733.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int maxH = 0, answer;

        for (int tc = 1; tc < T + 1; tc++) {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            answer = 1;

            for (int r = 0; r < cheese.length; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < cheese[r].length; c++) {
                    cheese[r][c] = Integer.parseInt(st.nextToken());

                    maxH = Math.max(maxH, cheese[r][c]);
                }
            }

            for (int i = 1; i < maxH + 1; i++) {
                eat(i);
                answer = Math.max(answer, getCheeseCnt());
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static void eat(int n) {
        for (int r = 0; r < cheese.length; r++) {
            for (int c = 0; c < cheese[r].length; c++) {
                if (cheese[r][c] == n) cheese[r][c] = 0;
            }
        }
    }

    private static int getCheeseCnt() {
        visited = new boolean[N][N];
        int nr, nc, cnt = 0;
        int[] cur;
        queue.clear();

        for (int r = 0; r < cheese.length; r++) {
            for (int c = 0; c < cheese[r].length; c++) {
                if (cheese[r][c] > 0 && !visited[r][c]) {
                    visited[r][c] = true;
                    cnt++;
                    queue.offer(new int[] {r, c});

                    while (!queue.isEmpty()) {
                        cur = queue.poll();

                        for (int d = 0; d < dir.length; d++) {
                            nr = cur[0] + dir[d][0];
                            nc = cur[1] + dir[d][1];

                            if (nr >= 0 && nr < cheese.length && nc >= 0 && nc < cheese[r].length
                                    && cheese[nr][nc] > 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}

package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 2636. 치즈 */
public class Problem2636 {
    static int R, C, curCnt, preCnt, time;
    static int[][] cheese, dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static boolean[][] air;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2636.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cheese = new int[R][C];
        air = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                cheese[r][c] = Integer.parseInt(st.nextToken());

                if (cheese[r][c] == 1) curCnt++;
            }
        }

        while (curCnt > 0) {
            preCnt = curCnt;
            time++;

            getAir();
            melt();
        }

        System.out.println(time);
        System.out.println(preCnt);

        br.close();
    }

    private static void getAir() {
        air = new boolean[R][C];
        air[0][0] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});

        int nr, nc;
        int[] cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int[] d : dir) {
                nr = cur[0] + d[0];
                nc = cur[1] + d[1];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C
                        && cheese[nr][nc] == 0 && !air[nr][nc]) {
                    air[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }

    private static void melt() {
        int nr, nc;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (cheese[r][c] == 1) {
                    for (int[] d : dir) {
                        nr = r + d[0];
                        nc = c + d[1];

                        if (air[nr][nc]) {
                            cheese[r][c] = 0;
                            curCnt--;

                            break;
                        }
                    }
                }
            }
        }
    }
}

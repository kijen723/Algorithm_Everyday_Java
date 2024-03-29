package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/* SWEA 5656. [모의 SW 역량테스트] 벽돌 깨기 */
public class Problem5656 {
    static int N, R, C, answer;
    static int[] per, num;
    static int[][] baseMap, map, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5656.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            baseMap = new int[R][C];
            map = new int[R][C];

            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < C; c++) {
                    baseMap[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            per = new int[N];
            num = new int[C];

            for (int c = 0; c < C; c++) {
                num[c] = c;
            }

            getPermutation(0);

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    static void getPermutation(int depth) {
        if (depth == N) {
            drop();
            answer = Math.min(answer, getRemain());

            return;
        }

        for (int i = 0; i < num.length; i++) {
            per[depth] = num[i];
            getPermutation(depth + 1);
        }
    }

    static void drop() {
        copyMap();

        for (int i = 0; i < per.length; i++) {
            for (int r = 0; r < R; r++) {
                if (map[r][per[i]] != 0) {
                    destory(r, per[i]);
                    break;
                }
            }
        }
    }

    static void destory(int r, int c) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {r, c});

        while (!dq.isEmpty()) {
            int[] p = dq.poll();

            for (int[] d : dir) {
                for (int i = 1; i < map[p[0]][p[1]]; i++) {
                    int nr = p[0] + (d[0] * i);
                    int nc = p[1] + (d[1] * i);

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }

                    if (map[nr][nc] > 1) {
                        dq.offer(new int[] {nr, nc});
                    } else {
                        map[nr][nc] = 0;
                    }
                }
            }

            map[p[0]][p[1]] = 0;
        }

        getDown();
    }

    static void getDown() {
        for (int r = R - 1; r > 0; r--) {
            for (int c = C - 1; c >= 0; c--) {
                boolean b = false;
                while (map[r][c] == 0 && !b) {
                    b = true;
                    for (int nr = r; nr > 0; nr--) {
                        map[nr][c] = map[nr - 1][c];

                        if (map[nr][c] != 0) {
                            b = false;
                        }
                    }

                    map[0][c] = 0;
                }
            }
        }
    }

    static int getRemain() {
        int cnt = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void copyMap() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] = baseMap[r][c];
            }
        }
    }
}

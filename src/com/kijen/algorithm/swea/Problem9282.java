package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 9282. 초콜릿과 건포도 */
public class Problem9282 {
    static int R, C;
    static int[][] map, sub;
    static int[][][][] mem;

    static int cut(int rs, int cs, int re, int ce) {
        if (re == rs && ce == cs) {
            return 0;
        }

        if (mem[rs][cs][re][ce] != Integer.MAX_VALUE) {
            return mem[rs][cs][re][ce];
        }

        int sum = sub[re][ce] - sub[re][cs - 1] - sub[rs - 1][ce] + sub[rs - 1][cs - 1];

        for (int i = rs; i < re; i++) {
            if (mem[rs][cs][i][ce] == Integer.MAX_VALUE) {
                mem[rs][cs][i][ce] = cut(rs, cs, i, ce);
            }

            if (mem[i + 1][cs][re][ce] == Integer.MAX_VALUE) {
                mem[i + 1][cs][re][ce] = cut(i + 1, cs, re, ce);
            }

            mem[rs][cs][re][ce] = Math.min(mem[rs][cs][re][ce], (mem[rs][cs][i][ce] + mem[i + 1][cs][re][ce] + sum));
        }

        for (int i = cs; i < ce; i++) {
            if (mem[rs][cs][re][i] == Integer.MAX_VALUE) {
                mem[rs][cs][re][i] = cut(rs, cs, re, i);
            }

            if (mem[rs][i + 1][re][ce] == Integer.MAX_VALUE) {
                mem[rs][i + 1][re][ce] = cut(rs, i + 1, re, ce);
            }

            mem[rs][cs][re][ce] = Math.min(mem[rs][cs][re][ce], (mem[rs][cs][re][i] + mem[rs][i + 1][re][ce] + sum));
        }

        return mem[rs][cs][re][ce];
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input9282.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[R + 1][C + 1];
            sub = new int[R + 1][C + 1];
            mem = new int[R + 1][C + 1][R + 1][C + 1];

            for (int r = 1; r <= R; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 1; c <= C; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int r = 1; r <= R; r++) {
                for (int c = 1; c <= C; c++) {
                    sub[r][c] = map[r][c] + sub[r - 1][c] + sub[r][c - 1] - sub[r - 1][c - 1];
                }
            }

            for (int r1 = 1; r1 <= R; r1++) {
                for (int c1 = 1; c1 <= C; c1++) {
                    for (int r2 = 1; r2 <= R; r2++) {
                        for (int c2 = 1; c2 <= C; c2++) {
                            mem[r1][c1][r2][c2] = Integer.MAX_VALUE;
                        }
                    }
                }
            }

            int answer = cut(1, 1, R, C);

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }
}

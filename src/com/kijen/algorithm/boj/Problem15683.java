package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* BOJ 15683. 감시 */
public class Problem15683 {
    static int N, M, watch;
    static int[][] map;
    static int[][][][] dir = {
            {{{0, 1}}, {{1, 0}}, {{-1, 0}}, {{0, -1}}},
            {{{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}},
            {{{0, 1}, {-1, 0}}, {{-1, 0}, {0, -1}}, {{0, -1}, {1, 0}}, {{1, 0}, {0, 1}}},
            {{{0, 1}, {-1, 0}, {0, -1}}, {{-1, 0}, {0, -1}, {1, 0}}, {{0, -1}, {1, 0}, {0, 1}}, {{1, 0}, {0, 1}, {-1, 0}}},
            {{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}}
    };
    static List<int[]> cctvs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input15683.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int answer = N * M;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] > 0 && map[r][c] < 6) {
                    cctvs.add(new int[] {r, c, map[r][c]});
                }

                if (map[r][c] != 0) answer--;
            }
        }

        getBlind(0, 0);

        System.out.println(answer - watch);

        br.close();
    }

    private static void getBlind(int n, int cnt) {
        if (n == cctvs.size()) {
            watch = Math.max(watch, cnt);
            return;
        }

        int[] cctv = cctvs.get(n);
        int r = cctv[0];
        int c = cctv[1];

        for (int a = 0; a < dir[cctv[2] - 1].length; a++) {
            for (int b = 0; b < dir[cctv[2] - 1][a].length; b++) {
                int go = 1;

                while (true) {
                    int nr = r + (go * dir[cctv[2] - 1][a][b][0]);
                    int nc = c + (go++ * dir[cctv[2] - 1][a][b][1]);

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
                    if (map[nr][nc] == 6) break;

                    if (map[nr][nc] == 0) {
                        map[nr][nc] = -1 * (n + 1);
                        cnt++;
                    }
                }
            }

            getBlind(n + 1, cnt);

            for (int b = 0; b < dir[cctv[2] - 1][a].length; b++) {
                int go = 1;

                while (true) {
                    int nr = r + (go * dir[cctv[2] - 1][a][b][0]);
                    int nc = c + (go++ * dir[cctv[2] - 1][a][b][1]);

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
                    if (map[nr][nc] == 6) break;

                    if (map[nr][nc] == -1 * (n + 1)) {
                        map[nr][nc] = 0;
                        cnt--;
                    }
                }
            }
        }
    }
}

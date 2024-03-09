package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 17144. 미세먼지 안녕! */
public class Problem17144 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17144.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int ac = 0;
        int[][] room = new int[R][C], dust;

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());

                if (room[r][c] == -1) {
                    ac = r;
                }
            }
        }

        int time = 0, nr, nc, spr;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (++time <= T) {
            dust = new int[R][C];

            for (int r = 0; r < room.length; r++) {
                for (int c = 0; c < room[r].length; c++) {
                    if (room[r][c] > 0) {
                        spr = room[r][c] / 5;

                        for (int i = 0; i < 4; i++) {
                            nr = r + dir[i][0];
                            nc = c + dir[i][1];

                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                                room[r][c] -= spr;
                                dust[nr][nc] += spr;
                            }
                        }
                    }
                }
            }

            for (int r = 0; r < room.length; r++) {
                for (int c = 0; c < room[r].length; c++) {
                    if (dust[r][c] > 0) {
                        room[r][c] += dust[r][c];
                    }
                }
            }

            nr = ac - 2;
            nc = 0;

            for (int i = 0; i < ac - 2; i++) {
                room[nr][nc] = room[--nr][nc];
            }

            for (int i = 0; i < C - 1; i++) {
                room[nr][nc] = room[nr][++nc];
            }

            for (int i = 0; i < ac - 1; i++) {
                room[nr][nc] = room[++nr][nc];
            }

            for (int i = 0; i < C - 2; i++) {
                room[nr][nc] = room[nr][--nc];
            }

            room[nr][nc] = 0;
            nr = ac + 1;
            nc = 0;

            for (int i = ac + 1; i < R - 1; i++) {
                room[nr][nc] = room[++nr][nc];
            }

            for (int i = 0; i < C - 1; i++) {
                room[nr][nc] = room[nr][++nc];
            }

            for (int i = ac; i < R - 1; i++) {
                room[nr][nc] = room[--nr][nc];
            }

            for (int i = 0; i < C - 2; i++) {
                room[nr][nc] = room[nr][--nc];
            }

            room[nr][nc] = 0;

        }

        int answer = 0;

        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                if (room[r][c] > 0) {
                    answer += room[r][c];
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}

package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 5653. [모의 SW 역량테스트] 줄기세포배양 */
public class Problem5653 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5653.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int T = Integer.parseInt(br.readLine());

        boolean flag;
        int N, M, K, vit, time, nx, ny, answer;
        int[][][] grid;

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            if (K % 2 == 0) {
                grid = new int[N + K][M + K][7];
            } else {
                grid = new int[N + K - 1][M + K - 1][7];
            }

            for (int i = K / 2; i < N + (K / 2); i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = K / 2; j < M + (K / 2); j++) {
                    vit = Integer.parseInt(st.nextToken());

                    if (vit != 0) {
                        grid[i][j][0] = 1;
                        grid[i][j][1] = 0;
                        grid[i][j][2] = 0;
                        grid[i][j][3] = vit;
                        grid[i][j][4] = 1;
                        grid[i][j][5] = vit;
                        grid[i][j][6] = vit;
                    }
                }
            }

            flag = true;
            time = 0;

            while (flag && ++time <= K) {
                flag = false;

                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j][0] == 1) {
                            flag = true;

                            if (grid[i][j][1] == 0) {
                                if (grid[i][j][2] != time && --grid[i][j][3] == 0) {
                                    grid[i][j][1] = 1;
                                }
                            } else {
                                for (int k = 0; k < 4; k++) {
                                    nx = i + dir[k][0];
                                    ny = j + dir[k][1];

                                    if (nx < 0 && nx >= grid.length && ny < 0 && ny >= grid[i].length) {
                                        continue;
                                    }

                                    if (grid[nx][ny][4] == 0 || (grid[nx][ny][2] == time && grid[i][j][5] > grid[nx][ny][5])) {
                                        grid[nx][ny][0] = 1;
                                        grid[nx][ny][1] = 0;
                                        grid[nx][ny][2] = time;
                                        grid[nx][ny][3] = grid[i][j][5];
                                        grid[nx][ny][4] = 1;
                                        grid[nx][ny][5] = grid[i][j][5];
                                        grid[nx][ny][6] = grid[i][j][5];
                                    }
                                }

                                if (--grid[i][j][6] == 0) {
                                    grid[i][j][0] = 0;
                                }
                            }
                        }
                    }
                }
            }

            answer = 0;

            for (int[][] x : grid) {
                for (int[] xy : x) {
                    if (xy[0] == 1) {
                        answer++;
                    }
                }
            }

            System.out.println("#"+ tc + " " + answer);
        }

        br.close();
    }
}

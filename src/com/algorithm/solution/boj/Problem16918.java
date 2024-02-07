package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 16918. 봄버맨 */
public class Problem16918 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input16918.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] inputStr;
        int[][] board = new int[R][C];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < R; i++) {
            inputStr = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                if (inputStr[j].equals(".")) {
                    board[i][j] = -1;
                } else {
                    board[i][j] = 1;
                }
            }
        }

        int time = 0, nx, ny;

        while (++time < N) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = 2;
                    } else if (board[i][j] == 0) {
                        board[i][j] = -2;

                        for (int d = 0; d < 4; d++) {
                            nx = i + dir[d][0];
                            ny = j + dir[d][1];

                            if (nx >= 0 && nx < R
                                    && ny >= 0 && ny < C
                                    && board[nx][ny] > 0) {
                                board[nx][ny] = -2;
                            }
                        }
                    } else if (board[i][j] > 0) {
                        board[i][j]--;
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == -2) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int[] x : board) {
            for (int xy : x) {
                if (xy == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }

            System.out.println();
        }

        br.close();
    }
}

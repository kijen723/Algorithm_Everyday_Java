package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 16919. 봄버맨2 */
public class Problem16919 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input16919.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ca = N % 4;
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

        boolean flag = false;
        int time = 0, nx, ny;

        if (N == 1) {
            flag = true;

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
        } else if (ca % 2 == 0) {
            flag = true;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print("O");
                }

                System.out.println();
            }
        } else if (ca == 1) {
            N = 5;
        } else {
            N = 3;
        }

        while (++time < N && !flag) {
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

        if (!flag) {
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
        }

        br.close();
    }
}

package com.algorithm.solution.swea;

import java.io.FileInputStream;
import java.util.Scanner;

/* SWEA 4615. 재미있는 오셀로 게임 */
public class Problem4615 {
    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("input/swea/Input4615.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[][] dir = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N + 1][N + 1];

            board[N / 2][N / 2] = 2;
            board[N / 2][(N / 2) + 1] = 1;
            board[(N / 2) + 1][N / 2] = 1;
            board[(N / 2) + 1][(N / 2) + 1] = 2;

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();

                boolean reverse;
                int tempX;
                int tempY;
                board[x][y] = color;

                for (int j = 0; j < 8; j++) {
                    tempX = x + dir[j][0];
                    tempY = y + dir[j][1];
                    reverse = false;

                    while (tempX > 0 && tempY > 0 && tempX < (N + 1) && tempY < (N + 1)) {
                        if (board[tempX][tempY] == 0) {

                            break;
                        }
                        else if (board[tempX][tempY] != color) {
                            reverse = true;
                        }
                        else if (reverse && board[tempX][tempY] == color) {
                            while (tempX != x || tempY != y) {
                                tempX -= dir[j][0];
                                tempY -= dir[j][1];
                                board[tempX][tempY] = color;
                            }

                            break;
                        }
                        else {

                            break;
                        }

                        tempX += dir[j][0];
                        tempY += dir[j][1];
                    }
                }
            }

            int black = 0;
            int white = 0;

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if(board[i][j] == 1)
                        black++;
                    else if(board[i][j] == 2)
                        white++;
                }
            }

            System.out.printf("#%d %d %d\n", test_case, black, white);
        }

        sc.close();
    }
}

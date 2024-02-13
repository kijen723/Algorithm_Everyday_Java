package com.algorithm.solution.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* JUNGOL 1733. 오목 */
public class Problem1733 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/jungol/Input1733.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
        int[][] board = new int[19][19];

        for (int r = 0; r < board.length; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < dir.length; k++) {
                        int idx = 1;
                        int cnt = 1;

                        if (i + (dir[k][0] * -1) >= 0 && j + (dir[k][1] * -1) >= 0 && i + (dir[k][0] * -1) < 19 && j + (dir[k][1] * -1) < 19 && board[i + (dir[k][0] * -1)][j + (dir[k][1] * -1)] == 1) {
                            continue;
                        }

                        while (i + (dir[k][0] * idx) >= 0 && j + (dir[k][1] * idx) >= 0 && i + (dir[k][0] * idx) < 19 && j + (dir[k][1] * idx) < 19 && board[i + (dir[k][0] * idx)][j + (dir[k][1] * idx)] == 1) {
                            cnt++;
                            idx++;
                        }

                        if (cnt == 5) {
                            System.out.println(1);
                            System.out.printf("%d %d\n", i + 1, j + 1);
                            System.exit(0);
                        }
                    }
                } else if (board[i][j] == 2) {
                    for (int k = 0; k < dir.length; k++) {
                        int idx = 1;
                        int cnt = 1;

                        if (i + (dir[k][0] * -1) >= 0 && j + (dir[k][1] * -1) >= 0 && i + (dir[k][0] * -1) < 19 && j + (dir[k][1] * -1) < 19 && board[i + (dir[k][0] * -1)][j + (dir[k][1] * -1)] == 2) {
                            continue;
                        }

                        while (i + (dir[k][0] * idx) >= 0 && j + (dir[k][1] * idx) >= 0 && i + (dir[k][0] * idx) < 19 && j + (dir[k][1] * idx) < 19 && board[i + (dir[k][0] * idx)][j + (dir[k][1] * idx)] == 2) {
                            cnt++;
                            idx++;
                        }

                        if (cnt == 5) {
                            System.out.println(2);
                            System.out.printf("%d %d\n", i + 1, j + 1);
                            System.exit(0);
                        }
                    }
                }
            }
        }

        System.out.println(0);

        br.close();
    }
}

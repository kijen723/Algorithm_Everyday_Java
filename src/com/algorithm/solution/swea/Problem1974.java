package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 1974. 스도쿠 검증 */
public class Problem1974 {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1974.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        boolean answer;

        for (int tc = 1; tc < T + 1; tc++) {
            for (int r = 0; r < sudoku.length; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < sudoku[r].length; c++) {
                    sudoku[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            answer = checkRow();
            if (answer) answer = checkColumn();
            if (answer) answer = checkSquare();

            System.out.println("#" + tc + " " + (answer ? 1 : 0));
        }

        br.close();
    }

    private static boolean checkRow() {
        boolean[] visited;

        for (int c = 0; c < 9; c++) {
            visited = new boolean[9 + 1];

            for (int r = 0; r < 9; r++) {
                if (!visited[sudoku[r][c]]) visited[sudoku[r][c]] = true;
                else return false;
            }

        }

        return true;
    }

    private static boolean checkColumn() {
        boolean[] visited;

        for (int r = 0; r < 9; r++) {
            visited = new boolean[9 + 1];

            for (int c = 0; c < 9; c++) {
                if (!visited[sudoku[r][c]]) visited[sudoku[r][c]] = true;
                else return false;
            }

        }

        return true;
    }

    private static boolean checkSquare() {
        boolean[] visited;

        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                visited = new boolean[9 + 1];

                for (int nr = r; nr < r + 3; nr++) {
                    for (int nc = c; nc < c + 3; nc++) {
                        if (!visited[sudoku[nr][nc]]) visited[sudoku[nr][nc]] = true;
                        else return false;
                    }
                }
            }
        }

        return true;
    }
}

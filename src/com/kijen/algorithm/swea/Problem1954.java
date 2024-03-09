package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

/* SWEA 1954. 달팽이 숫자 */
public class Problem1954 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1954.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int tc = 1; tc < T + 1; tc++) {
            int N = Integer.parseInt(br.readLine());
            int number = 1;
            boolean[][] visited = new boolean[N][N];
            int[] coord = {0, -1, 0};
            int[][] snailArr = new int[N][N];

            while (number <= N * N) {
                if (coord[0] + dir[coord[2]][0] >= 0 && coord[0] + dir[coord[2]][0] < N
                        && coord[1] + dir[coord[2]][1] >= 0 && coord[1] + dir[coord[2]][1] < N
                        && !visited[coord[0] + dir[coord[2]][0]][coord[1] + dir[coord[2]][1]]) {
                    coord[0] += dir[coord[2]][0];
                    coord[1] += dir[coord[2]][1];
                    snailArr[coord[0]][coord[1]] = number++;
                    visited[coord[0]][coord[1]] = true;
                } else {
                    coord[2] = (coord[2] + 1) % 4;
                }
            }

            System.out.println("#" + tc);

            for (int[] arr : snailArr) {
                for (int n : arr) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }

        br.close();
    }
}

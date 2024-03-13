package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 3197. 백조의 호수 */
public class Problem3197 {
    static int R, C;
    static int[][] map, dic = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static void move() {

    }

    static void meet() {

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input3197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            String input = br.readLine();

            for (int c = 0; c < C; c++) {
                if (input.charAt(c) == 'X') {
                    map[r][c] = 1;
                } else if (input.charAt(c) == 'L') {
                    map[r][c] = 2;
                }
            }
        }

        System.out.println();


        br.close();
    }
}

package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 1074. Z */
public class Problem1074 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1074.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(Z(N, r, c));

        br.close();
    }

    private static int Z(int N, int r, int c) {
        if (N == 0) return 0;

        return ((r % 2) * 2) + (c % 2) + (4 * Z(N - 1, (r / 2), (c / 2)));
    }
}


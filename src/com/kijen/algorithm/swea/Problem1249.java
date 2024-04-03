package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 1249. [S/W 문제해결 응용] 4일차 - 보급로 */
public class Problem1249 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {


            System.out.println("#" + tc + " ");
        }

        br.close();
    }
}

package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 2112. [모의 SW 역량테스트] 보호 필름 */
public class Problem2112 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {


            System.out.println("#" + tc + " ");
        }

        br.close();
    }
}

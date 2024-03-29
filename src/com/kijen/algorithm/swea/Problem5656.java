package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 5656. [모의 SW 역량테스트] 벽돌 깨기 */
public class Problem5656 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5656.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {


            System.out.println("#" + tc + " ");
        }

        br.close();
    }
}

package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 1493. 박스 채우기 */
public class Problem1493 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1493.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int[] cubes = new int[N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            cubes[size] = Integer.parseInt(st.nextToken());
        }

        long cumCnt = 0;
        long cubeCnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            cumCnt <<= 3;

            long divideCnt = (long) (l >> i) * (w >> i) * (h >> i) - cumCnt;
            long minCnt = Math.min((long) cubes[i], divideCnt);

            cumCnt += minCnt;
            cubeCnt += minCnt;
        }

        if (cumCnt == (long) l * w * h) {
            System.out.println(cubeCnt);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

}

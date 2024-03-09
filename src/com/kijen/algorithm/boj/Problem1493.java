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

        int[] cubes = new int[20];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            cubes[size] = Integer.parseInt(st.nextToken());
        }



        br.close();
    }

    private static void getCubes(int l, int w, int h, int cnt, int[] cubes) {
        for (int i = cubes.length - 1; i >= 0; i++) {
            if (cubes[i] == 0) {
                continue;
            }

            int cubeLen = (int) Math.pow(2, i);

            if (cubeLen <= l && cubeLen <= w && cubeLen <= h) {

            }
        }
    }
}

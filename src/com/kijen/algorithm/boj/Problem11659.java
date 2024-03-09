package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 11659. 구간 합 구하기 4 */
public class Problem11659 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11659.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int c = 0; c < M; c++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(numbers[j] - numbers[i - 1]);
        }

        br.close();
    }
}

package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 16435. 스네이크버드 */
public class Problem16435 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input16435.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] fruits = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fruits);

        for (int fruit : fruits) {
            if (L >= fruit) L++;
        }

        System.out.println(L);

        br.close();
    }
}

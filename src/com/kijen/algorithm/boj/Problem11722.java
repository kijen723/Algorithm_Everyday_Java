package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 11722. 가장 긴 감소하는 부분 수열 */
public class Problem11722 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11722.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else if (A[i] == A[j]) {
                    dp[i] = dp[j];
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

        br.close();
    }
}

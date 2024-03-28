package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 14501. 퇴사 */
public class Problem14501 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input14501.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[31];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

            if (i + T[i] > N) {
                P[i] = 0;
            }
        }

        int answer = 0;

        for (int i = N - 1; i >= 0; i--) {
            int max = Math.max(dp[i + T[i]] + P[i], dp[i + 1]);

            if (dp[i] < max) {
                dp[i] = max;
            }

            if (answer < dp[i]) {
                answer = dp[i];
            }
        }

        System.out.println(answer);

        br.close();
    }
}

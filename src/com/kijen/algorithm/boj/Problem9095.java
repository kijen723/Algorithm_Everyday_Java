package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 9095. 1, 2, 3 더하기 */
public class Problem9095 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input9095.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp;

            if (n <= 3) {
                dp = new int[4];
            } else {
                dp = new int[n + 1];
            }

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        }

        br.close();
    }
}

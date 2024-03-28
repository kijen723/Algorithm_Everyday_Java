package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 11726. 2×n 타일링 */
public class Problem11726 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11726.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = ((dp[i - 1] % 10007) + (dp[i - 2] % 10007)) % 10007;
        }

        System.out.println(dp[n]);

        br.close();
    }
}

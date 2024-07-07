package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 11057. 오르막 수 */
public class Problem11057 {
    static int MODULE = 10007;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input11057.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = ((dp[i - 1][j] % MODULE) + (dp[i][j - 1] % MODULE)) % MODULE;
            }
        }

        System.out.println(dp[n][9]);

        br.close();
    }
}

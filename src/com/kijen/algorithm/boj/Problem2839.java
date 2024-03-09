package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 2839. 설탕 배달 */
public class Problem2839 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2839.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(delivery(N, 0));

        br.close();
    }

    private static int delivery(int n, int cnt) {
        if (n == 0) {
            return cnt;
        } else if (n < 0){
            return -1;
        } else if (n % 5 == 0) {
            return cnt + (n / 5);
        } else {
            return delivery(n - 3, cnt + 1);
        }
    }
}

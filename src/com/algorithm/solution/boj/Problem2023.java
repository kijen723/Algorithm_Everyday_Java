package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 2023. 신기한 소수 */
public class Problem2023 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2023.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] first = {2, 3, 5, 7};
        int[] other = {1, 3, 7, 9};

        for (int i : first) {
            printPrime(N, other, i);
        }

        br.close();
    }

    private static void printPrime(int n, int[] other, int prime) {
        if (n == 1) {
            System.out.println(prime);

            return;
        }

        for (int i : other) {
            if (isPrime((prime * 10) + i)) {
                printPrime(n - 1, other, (prime * 10) + i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

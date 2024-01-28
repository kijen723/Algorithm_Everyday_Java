package com.algorithm.solution.boj;

import java.io.FileInputStream;
import java.util.Scanner;

/* BOJ 2798. 블랙잭 */
public class Problem2798 {
    static int N, M, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2798.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        answer = 0;
        pickUp(0, 0, 0);

        System.out.println(answer);

        sc.close();
    }

    static void pickUp(int count, int pick, int add) {
        if (pick == 3) {
            if (add <= M && answer < add) {
                answer = add;
            }

            return;
        }

        if (count == N) {

            return;
        }

        pickUp(count + 1, pick + 1, add + arr[count]);
        pickUp(count + 1, pick, add);
    }
}

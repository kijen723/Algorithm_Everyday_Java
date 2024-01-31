package com.algorithm.solution.swea;

import java.io.FileInputStream;
import java.util.Scanner;

/* SWEA 1234. [S/W 문제해결 기본] 10일차 - 비밀번호 */
public class Problem1234 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1234.txt"));
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int pwLen = sc.nextInt();
            int[] pw = new int[pwLen];

            String[] pwInput = sc.next().split("");

            for(int i = 0; i < pwLen; i++) {
                pw[i] = Integer.parseInt(pwInput[i]);
            }

            int answer = 1;

            while(answer != 0) {
                answer = 0;

                for(int i = 0; i < pwLen - 1; i++) {
                    int j = i + 1;

                    while(pw[j] == -1 && j < pwLen - 1) {
                        j++;
                    }

                    if(pw[i] != -1 && pw[i] == pw[j]) {
                        pw[i] = -1;
                        pw[j] = -1;
                        answer++;
                    }
                }
            }

            System.out.printf("#%d ", test_case);

            for(int i = 0; i < pwLen; i++) {
                if(pw[i] != -1)
                    System.out.print(pw[i]);
            }

            System.out.println();
        }

        sc.close();
    }
}

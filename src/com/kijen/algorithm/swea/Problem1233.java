package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사 */
public class Problem1233 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1233.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean flag;
        String[] asdf;

        for (int tc = 1; tc < 11; tc++) {
            flag = false;
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                asdf = br.readLine().split(" ");

                if (asdf.length == 2) {
                    if (asdf[1].charAt(0) == '+'
                            || asdf[1].charAt(0) == '-'
                            || asdf[1].charAt(0) == '*'
                            || asdf[1].charAt(0) == '/') {
                        flag = true;
                    }
                } else {
                    if (asdf[1].charAt(0) != '+'
                            && asdf[1].charAt(0) != '-'
                            && asdf[1].charAt(0) != '*'
                            && asdf[1].charAt(0) != '/') {
                        flag = true;
                    }
                }
            }

            if (flag) {
                System.out.println("#" + tc + " " + 0);
            } else {
                System.out.println("#" + tc + " " + 1);
            }
        }

        br.close();
    }
}

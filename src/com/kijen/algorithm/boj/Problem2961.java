package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 2961. 도영이가 만든 맛있는 음식 */
public class Problem2961 {
    static int N;
    static int[][] ingres;
    static int answer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2961.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ingres = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingres[i][0] = Integer.parseInt(st.nextToken());
            ingres[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;

        cook(0, 1, 0);

        System.out.println(answer);

        br.close();
    }

    private static void cook(int n, int sour, int bitter) {
        if (sour != 1 && bitter != 0) {
            answer = Math.min(answer, Math.abs(sour - bitter));
        }

        if (n >= N) {
            return;
        }

        cook(n + 1, sour * ingres[n][0], bitter + ingres[n][1]);
        cook(n + 1, sour, bitter);
    }
}

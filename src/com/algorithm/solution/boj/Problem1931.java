package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 1931. 회의실 배정 */
public class Problem1931 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1931.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < meetings.length; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int end = meetings[0][1], answer = 1;

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= end) {
                end = meetings[i][1];
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}

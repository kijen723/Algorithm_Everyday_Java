package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 2001. 파리 퇴치 */
public class Problem2001 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input2001.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] area = new int[N][N];

            for (int i = 0; i < area.length; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < area[i].length; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < area.length - M + 1; i++) {
                for (int j = 0; j < area[i].length - M + 1; j++) {
                    int killCnt = 0;

                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            killCnt += area[k][l];
                        }
                    }

                    answer = Math.max(answer, killCnt);
                }
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }
}

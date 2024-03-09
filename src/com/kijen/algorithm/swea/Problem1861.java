package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA 1861. 정사각형 방 */
public class Problem1861 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1861.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, nx, ny, n, cnt;
        int[] cur;
        int[] answer;
        int[][] A;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int tc = 1; tc < T + 1; tc++) {
            N = Integer.parseInt(br.readLine());
            A = new int[N][N];
            answer = new int[] {Integer.MAX_VALUE, 0};

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    n = A[i][j];
                    cnt = 1;
                    queue.offer(new int[] {i, j});

                    while (!queue.isEmpty()) {
                        cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            nx = cur[0] + dir[d][0];
                            ny = cur[1] + dir[d][1];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N
                                    && A[cur[0]][cur[1]] + 1 == A[nx][ny]) {
                                cnt++;
                                queue.offer(new int[] {nx, ny});
                            }
                        }
                    }

                    if (answer[1] < cnt) {
                        answer[0] = n;
                        answer[1] = cnt;
                    } else if (answer[1] == cnt && answer[0] > n) {
                        answer[0] = n;
                    }
                }
            }

            System.out.println("#" + tc + " " +answer[0] + " " + answer[1]);
        }

        br.close();
    }
}

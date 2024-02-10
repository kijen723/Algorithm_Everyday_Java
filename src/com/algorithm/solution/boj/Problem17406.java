package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 17406. 배열 돌리기 4 */
public class Problem17406 {
    static int N, M, K, perIdx, r, c, s, temp, answer = Integer.MAX_VALUE;
    static int[][] A = new int[N][M], B, idxs;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17406.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < A.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arrK = new int[K][3];

        for (int i = 0; i < arrK.length; i++) {
            st = new StringTokenizer(br.readLine());
            arrK[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arrK[i][1] = Integer.parseInt(st.nextToken()) - 1;
            arrK[i][2] = Integer.parseInt(st.nextToken());
        }

        int facK = 1;

        for (int i = K; i > 0; i--) {
            facK *= i;
        }

        idxs = new int[facK][K];

        permutation(0, new int[K], new boolean[K]);

        for (int[] per : idxs) {
            B = copyArr(A);

            for (int k = 0; k < per.length; k++) {
                r = arrK[per[k]][0];
                c = arrK[per[k]][1];
                s = arrK[per[k]][2];

                for (int i = 0; i < s; i++) {
                    rot(r - s + i, c - s + i, (s - i) * 2);
                }
            }

            for (int i = 0; i < N; i++) {
                temp = 0;

                for (int j = 0; j < M; j++) {
                    temp += B[i][j];
                }

                answer = Math.min(answer, temp);
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] result = new int[N][M];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j] ;
            }
        }

        return result;
    }

    private static void rot(int r, int c, int n) {
        int nr = r;
        int nc = c;
        int temp = B[r][c];

        for (int i = 0; i < n * 4; i++) {
            if (i < n) B[r++][c] = B[++nr][nc];
            else if (i < n * 2) B[r][c++] = B[nr][++nc];
            else if (i < n * 3) B[r--][c] = B[--nr][nc];
            else if (i < (n * 4) - 1) B[r][c--] = B[nr][--nc];
            else B[r][c] = temp;
        }
    }

    private static void permutation(int idx, int[] arr, boolean[] visited) {
        if (idx == arr.length) {
            idxs[perIdx++] = arr;

            return;
        }

        int[] tempArr = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempArr[idx] = i;
                permutation(idx + 1, tempArr, visited);
                visited[i] = false;
            }
        }
    }
}

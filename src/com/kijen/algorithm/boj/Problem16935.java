package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 16935. 배열 돌리기 3 */
public class Problem16935 {
    static int N, M, R;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input16935.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int rn;

        for (int i = 0; i < R; i++) {
            rn = Integer.parseInt(st.nextToken());

            if (rn == 1) r1();
            else if (rn == 2) r2();
            else if (rn == 3) r3();
            else if (rn == 4) r4();
            else if (rn == 5) r5();
            else if (rn == 6) r6();
        }

        for (int[] r : A) {
            for (int rc : r) {
                System.out.print(rc + " ");
            }

            System.out.println();
        }

        br.close();
    }

    static int temp;

    private static void r1 () {
        for (int i = 0; i < A.length / 2; i++) {
            for (int j = 0; j < A[i].length; j++) {
                temp = A[i][j];
                A[i][j] = A[A.length - i - 1][j];
                A[A.length - i - 1][j] = temp;
            }
        }
    }

    private static void r2 () {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = temp;
            }
        }
    }

    private static void r3 () {
        int[][] tempA = new int[A[0].length][A.length];

        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                tempA[i][j] = A[A.length - j - 1][i];
            }
        }

        A = tempA;
    }

    private static void r4 () {
        int[][] tempA = new int[A[0].length][A.length];

        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                tempA[i][j] = A[j][A[0].length - i - 1];
            }
        }

        A = tempA;
    }

    private static void r5 () {
        int[][] tempA = new int[A.length][A[0].length];

        for (int i = 0; i < A.length / 2; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                tempA[i][j] = A[i + A.length / 2][j];
            }
        }

        for (int i = 0; i < A.length / 2; i++) {
            for (int j = A[0].length / 2; j < A[0].length; j++) {
                tempA[i][j] = A[i][j - A[0].length / 2];
            }
        }

        for (int i = A.length / 2; i < A.length; i++) {
            for (int j = A[0].length / 2; j < A[0].length; j++) {
                tempA[i][j] = A[i - A.length / 2][j];
            }
        }

        for (int i = A.length / 2; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                tempA[i][j] = A[i][j + A[0].length / 2];
            }
        }

        A = tempA;
    }

    private static void r6 () {
        int[][] tempA = new int[A.length][A[0].length];

        for (int i = 0; i < A.length / 2; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                tempA[i][j] = A[i][j + A[0].length / 2];
            }
        }

        for (int i = 0; i < A.length / 2; i++) {
            for (int j = A[0].length / 2; j < A[0].length; j++) {
                tempA[i][j] = A[i + A.length / 2][j];
            }
        }

        for (int i = A.length / 2; i < A.length; i++) {
            for (int j = A[0].length / 2; j < A[0].length; j++) {
                tempA[i][j] = A[i][j - A[0].length / 2];
            }
        }

        for (int i = A.length / 2; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                tempA[i][j] = A[i - A.length / 2][j];
            }
        }

        A = tempA;
    }
}

package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 7465. 창용 마을 무리의 개수 */
public class Problem7465 {
    static int[] disjointSet;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input7465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            disjointSet = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                disjointSet[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int answer = 0;

            for (int i = 1; i < N + 1; i++) {
                if (disjointSet[i] == i) answer++;
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) disjointSet[b] = a;
        else disjointSet[a] = b;
    }

    private static int find(int n) {
        if (disjointSet[n] == n) return n;
        else return disjointSet[n] = find(disjointSet[n]);
    }
}

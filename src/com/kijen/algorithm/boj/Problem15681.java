package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* BOJ 15681. 트리와 쿼리 */
public class Problem15681 {
    static int N, R, Q;
    static int[] node;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input15681.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        node = new int[N + 1];
        visited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        makeTree(R);

        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(node[n]);
        }

        br.close();
    }

    public static int makeTree(int cur) {
        visited[cur] = true;

        int result = 1;
        ArrayList<Integer> curAdj = adjList[cur];

        for (int i = 0; i < curAdj.size(); i++) {
            int target = curAdj.get(i);

            if (!visited[target]) {
                result += makeTree(target);
            }
        }

        node[cur] = result;

        return result;
    }
}

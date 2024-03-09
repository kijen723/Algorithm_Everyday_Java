package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 1260. DFS와 BFS */
public class Problem1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1260.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a, b;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        bfs(V);

        br.close();
    }

    private static void dfs(int n) {
        visited[n] = true;
        System.out.print(n + " ");

        for (int i = 0; i < graph[n].size(); i++) {
            if (!visited[graph[n].get(i)]) {
                dfs(graph[n].get(i));
            }
        }
    }

    private static void bfs(int n) {
        int nn;
        visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[n] = true;
        queue.add(n);

        while (!queue.isEmpty()) {
            nn = queue.poll();
            System.out.print(nn + " ");

            for (int i = 0; i < graph[nn].size(); i++) {
                if (!visited[graph[nn].get(i)]) {
                    visited[graph[nn].get(i)] = true;
                    queue.add(graph[nn].get(i));
                }
            }
        }

        System.out.println();
    }
}


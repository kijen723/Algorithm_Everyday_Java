package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* BOJ 1753. 최단경로 */
public class Problem1753 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1753.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] adjList = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[] {v, w});
        }

        int[] dijkstra = new int[V + 1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {K, 0});
        dijkstra[K] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int i = 0; i < adjList[cur[0]].size(); i++) {
                int[] next = adjList[cur[0]].get(i);
                int dis = cur[1] + next[1];
                
                if (dis < dijkstra[next[0]]) {
                    dijkstra[next[0]] = dis;
                    pq.offer(new int[] {next[0], dis});
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            System.out.println(dijkstra[i] == Integer.MAX_VALUE ? "INF" : dijkstra[i]);
        }

        br.close();
    }
}

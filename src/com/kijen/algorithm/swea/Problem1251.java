package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* SWEA 1251. [S/W 문제해결 응용] 4일차 - 하나로 */
public class Problem1251 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] island = new int[N][2];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            ArrayList<long[]>[] adjList = new ArrayList[N];


            for (int i = 0; i < N; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long money = (long) Math.pow(island[i][0] - island[j][0], 2) + (long) Math.pow(island[i][1] - island[j][1], 2);
                    adjList[i].add(new long[] {j, money});
                    adjList[j].add(new long[] {i, money});
                }
            }

            System.out.println("#" + tc + " " + Math.round(prim(adjList) * E));
        }

        br.close();
    }

    private static long prim(ArrayList<long[]>[] adjList) {
        long answer = 0;
        int idx = 0;
        boolean[] visited = new boolean[adjList.length];
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));

        visited[0] = true;

        for (int i = 0; i < adjList[0].size(); i++) {
            long[] cur = adjList[0].get(i);
            pq.offer(new long[] {cur[0], cur[1]});
        }

        while (idx < adjList.length && !pq.isEmpty()) {
            long[] cur = pq.poll();

            if (!visited[(int) cur[0]]) {
                visited[(int) cur[0]] = true;

                for (int i = 0; i < adjList[(int) cur[0]].size(); i++) {
                    long[] tmp = adjList[(int) cur[0]].get(i);
                    pq.offer(new long[] {tmp[0], tmp[1]});
                }

                answer += cur[1];
                idx++;
            }
        }

        return answer;
    }
}

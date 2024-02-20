package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 2252. 줄 세우기 */
public class Problem2252 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2252.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start, end, cur;
        int[] edge = new int[N + 1];
        List<Integer>[] lens = new List[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N + 1; i++) {
            lens[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            lens[start].add(end);
            edge[end]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (edge[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < lens[cur].size(); i++) {
                edge[lens[cur].get(i)]--;

                if (edge[lens[cur].get(i)] == 0) {
                    queue.offer(lens[cur].get(i));
                }
            }
        }

        br.close();
    }
}

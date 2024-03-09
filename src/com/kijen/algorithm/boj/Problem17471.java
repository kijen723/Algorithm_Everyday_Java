package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 17471. 게리맨더링 */
public class Problem17471 {
    static int N, answer = Integer.MAX_VALUE;
    static int[] person;
    static int[][] adjArr;
    static boolean[] selected;
    static ArrayList<Integer> groupA;
    static ArrayList<Integer> groupB;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17471.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        person = new int[N + 1];
        adjArr = new int[N + 1][];
        selected = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for (int start = 1; start < N + 1; start++) {
            st = new StringTokenizer(br.readLine());
            adjArr[start] = new int[Integer.parseInt(st.nextToken())];

            for (int end = 0; end < adjArr[start].length; end++) {
                adjArr[start][end] = Integer.parseInt(st.nextToken());
            }
        }

        select(1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }

    private static void select(int depth) {
        if (depth == N + 1) {
            groupA = new ArrayList<>();
            groupB = new ArrayList<>();

            for (int i = 1; i < N + 1; i++) {
                if (selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            if (checkCounter()) return;

            checkPerson();

            return;
        }

        selected[depth] = true;
        select(depth + 1);
        selected[depth] = false;
        select(depth + 1);
    }

    private static boolean checkCounter() {
        if (groupA.isEmpty() || groupB.isEmpty()) return true;

        int cnt = 1;
        boolean[] visited = new boolean[N + 1];
        visited[groupA.get(0)] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(groupA.get(0));

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adjArr[cur].length; i++) {
                if (!visited[adjArr[cur][i]] && groupA.contains(adjArr[cur][i])) {
                    visited[adjArr[cur][i]] = true;
                    queue.offer(adjArr[cur][i]);
                    cnt++;
                }
            }
        }

        if (cnt != groupA.size()) return true;

        cnt = 1;
        visited = new boolean[N + 1];
        visited[groupB.get(0)] = true;
        queue = new ArrayDeque<>();
        queue.offer(groupB.get(0));

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adjArr[cur].length; i++) {
                if (!visited[adjArr[cur][i]] && groupB.contains(adjArr[cur][i])) {
                    visited[adjArr[cur][i]] = true;
                    queue.offer(adjArr[cur][i]);
                    cnt++;
                }
            }
        }

        if (cnt != groupB.size()) return true;

        return false;
    }

    private static void checkPerson() {
        int aCnt = 0;
        int bCnt = 0;

        for (int i : groupA) {
            aCnt += person[i];
        }

        for (int i : groupB) {
            bCnt += person[i];
        }

        answer = Math.min(answer, Math.abs(aCnt - bCnt));
    }
}

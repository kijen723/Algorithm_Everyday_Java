package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* BOJ 2606. 바이러스 */
public class Problem2606 {
    static int com, pair, answer = 0;
    static List<Integer>[] abjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2606.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        com = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        int a, b = 0;
        abjList = new LinkedList[com + 1];
        visited = new boolean[com + 1];

        for (int i = 0; i < abjList.length; i++) {
            abjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            abjList[a].add(b);
            abjList[b].add(a);
        }

        visited[1] = true;
        cntVirus(1);
        System.out.println(answer);

        br.close();
    }

    private static void cntVirus(int a) {
        for (int i = 0; i < abjList[a].size(); i++) {
            if (!visited[abjList[a].get(i)]) {
                visited[abjList[a].get(i)] = true;
                answer++;
                cntVirus(abjList[a].get(i));
            }
        }
    }
}

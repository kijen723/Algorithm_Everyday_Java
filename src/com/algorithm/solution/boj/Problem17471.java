package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* BOJ 17471. 게리맨더링 */
public class Problem17471 {
    static int[] parent, person;
    static ArrayList<Integer>[] abjList;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17471.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        person = new int[N + 1];
        abjList = new ArrayList[N + 1];

        for (int i = 1; i < parent.length; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                abjList[i].add(Integer.parseInt(input[j]));
            }
        }



        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a <= b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = find(parent[n]);
    }
}

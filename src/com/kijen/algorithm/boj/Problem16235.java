package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 16235. 나무 재테크 */
public class Problem16235 {
    static int N, M, K;
    static int[][] map, fer, dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    static class Tree {
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input16235.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        fer = new int[N][N];

        for (int r = 0; r < N; r++) {
            Arrays.fill(map[r], 5);
        }

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                fer[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Tree> trees = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            trees.offer(new Tree(a,b,c));
        }

        for (int i = 0; i < K; i++) {
            ArrayDeque<Tree> alive = new ArrayDeque<>();
            ArrayDeque<Tree> dead = new ArrayDeque<>();

            while (!trees.isEmpty()) {
                Tree cur = trees.poll();

                if (map[cur.r][cur.c] >= cur.age) {
                    map[cur.r][cur.c] -= cur.age++;
                    alive.offer(cur);
                } else {
                    dead.offer(cur);
                }
            }

            while(!dead.isEmpty()) {
                Tree cur = dead.poll();
                map[cur.r][cur.c] += cur.age / 2;
            }

            while(!alive.isEmpty()) {
                Tree cur = alive.poll();

                if (cur.age % 5 == 0) {
                    for (int d = 0; d < dir.length; d++) {
                        int nr = cur.r + dir[d][0];
                        int nc = cur.c + dir[d][1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            continue;
                        }

                        trees.offer(new Tree(nr, nc, 1));
                    }
                }

                trees.offer(cur);
            }

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    map[r][c] += fer[r][c];
                }
            }
        }

        System.out.println(trees.size());

        br.close();
    }
}

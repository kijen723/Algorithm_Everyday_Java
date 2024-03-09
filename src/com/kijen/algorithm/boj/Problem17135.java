package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ 17135. 캐슬 디펜스 */
public class Problem17135 {
    static int N, M, D, totalEnemy = 0, curEnemy, killed = 0, answer = 0;
    static int[] archer = new int[3];;
    static int[][] map, curMap, dir = {{0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input17135.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        curMap = new int[N][M];

        for (int r = 0; r < map.length; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 1) totalEnemy++;
            }
        }

        setArcher(0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void setArcher(int depth, int n) {
        if (n == 3) {
            gameStart();

            answer = Math.max(answer, killed);

            return;
        }

        if (depth == M) return;

        archer[n] = depth;
        setArcher(depth + 1, n + 1);
        setArcher(depth + 1, n);
    }

    private static void gameStart() {
        killed = 0;
        curEnemy = totalEnemy;
        copyMap();

        int nr, nc;
        int[] cur;
        List<int[]> attacked = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        while (curEnemy > 0) {
            attacked.clear();

            for (int c : archer) {
                queue.clear();
                queue.offer(new int[] {N, c, 0});
                visited = new boolean[N][M];

                L : while (!queue.isEmpty()) {
                    cur = queue.poll();

                    for (int d = 0; d < dir.length; d++) {
                        nr = cur[0] + dir[d][0];
                        nc = cur[1] + dir[d][1];

                        if (nr >= 0 && nr < N && nc >= 0 & nc < M && !visited[nr][nc]) {
                            if (curMap[nr][nc] == 1) {
                                attacked.add(new int[] {nr, nc});

                                break L;
                            }

                            if (cur[2] + 1 < D) {
                                visited[nr][nc] = true;
                                queue.offer(new int[] {nr, nc, cur[2] + 1});
                            }
                        }
                    }
                }
            }

            for (int[] coord : attacked) {
                if (curMap[coord[0]][coord[1]] == 1) {
                    curMap[coord[0]][coord[1]] = 0;
                    curEnemy--;
                    killed++;
                }
            }

            advance();
        }
    }

    private static void copyMap() {
        for (int r = 0; r < curMap.length; r++) {
            for (int c = 0; c < curMap[r].length; c++) {
                curMap[r][c] = map[r][c];
            }
        }
    }

    private static void advance() {
        for (int r = curMap.length - 1; r >= 0; r--) {
            for (int c = curMap[r].length - 1; c >= 0; c--) {
                if (curMap[r][c] == 1) {
                    if (r == curMap.length - 1) {
                        curMap[r][c] = 0;
                        curEnemy--;
                    } else {
                        curMap[r][c] = 0;
                        curMap[r + 1][c] = 1;
                    }
                }
            }
        }
    }
}

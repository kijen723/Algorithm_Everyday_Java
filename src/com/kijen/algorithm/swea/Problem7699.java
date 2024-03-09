package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 7699. 수지의 수지 맞는 여행 */
public class Problem7699 {
    static int R, C, answer;
    static boolean[] visited;
    static int[][] map, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input7699.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            visited = new boolean[26];
            map = new int[R][C];

            for (int r = 0; r < map.length; r++) {
                String[] input = br.readLine().split("");

                for (int c = 0; c < map[r].length; c++) {
                    map[r][c] = input[c].charAt(0);
                }
            }

            answer = 1;
            visited[map[0][0] - 65] = true;
            dfs(0, 0, 1);

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    private static void dfs(int r, int c, int cnt) {
        if (cnt > 26) {
            return;
        }

        int nr, nc;

        for (int d = 0; d < 4; d++) {
            nr = r + dir[d][0];
            nc = c + dir[d][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[map[nr][nc] - 65]) {
                visited[map[nr][nc] - 65] = true;
                dfs(nr, nc, cnt + 1);
                visited[map[nr][nc] - 65] = false;
            }

            answer = Math.max(answer, cnt);
        }
    }
}

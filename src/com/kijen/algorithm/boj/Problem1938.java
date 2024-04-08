package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/* BOJ 1938. 통나무 옮기기 */
public class Problem1938 {
    static int N;
    static int[][] map;
    static boolean[][][] visited;

    static class Train {
        int fr, fc;
        int sr, sc;
        int tr, tc;
        int d;
        int cnt;
        int check;

        void setIn(int r, int c) {
            if (check == 0) {
                fr = r;
                fc = c;
                check++;
            } else if (check == 1) {
                sr = r;
                sc = c;
                check++;
            } else {
                tr = r;
                tc = c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input1938.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N][2];
        Train start = new Train();
        Train end = new Train();

        for (int r = 0; r < N; r++) {
            String input = br.readLine();

            for (int c = 0; c < N; c++) {
                char ch = input.charAt(c);

                if (ch == 'B') {
                    start.setIn(r, c);
                } else if (ch == 'E') {
                    end.setIn(r, c);
                } else if (ch == '1') {
                    map[r][c] = 1;
                }
            }
        }

        if (start.fc != start.sc) {
            start.d = 1;
        }

        ArrayDeque<Train> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.sr][start.sc][start.d] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            Train cur = queue.pop();

            if (cur.fc == end.fc && cur.fr == end.fr
                    && cur.sc == end.sc && cur.sr == end.sr
                    && cur.tc == end.tc && cur.tr == end.tr) {
                answer = cur.cnt;

                break;
            }

            if (cu(cur) && !visited[cur.sr - 1][cur.sc][cur.d]) {
                Train temp = new Train();
                temp.fr = cur.fr - 1;
                temp.fc = cur.fc;
                temp.sr = cur.sr - 1;
                temp.sc = cur.sc;
                temp.tr = cur.tr - 1;
                temp.tc = cur.tc;
                temp.d = cur.d;
                temp.cnt = cur.cnt + 1;
                queue.offer(temp);
                visited[temp.sr][temp.sc][temp.d] = true;
            }

            if (cd(cur) && !visited[cur.sr + 1][cur.sc][cur.d]) {
                Train temp = new Train();
                temp.fr = cur.fr + 1;
                temp.fc = cur.fc;
                temp.sr = cur.sr + 1;
                temp.sc = cur.sc;
                temp.tr = cur.tr + 1;
                temp.tc = cur.tc;
                temp.d = cur.d;
                temp.cnt = cur.cnt + 1;
                queue.offer(temp);
                visited[temp.sr][temp.sc][temp.d] = true;
            }

            if (cl(cur) && !visited[cur.sr][cur.sc - 1][cur.d]) {
                Train temp = new Train();
                temp.fr = cur.fr;
                temp.fc = cur.fc - 1;
                temp.sr = cur.sr;
                temp.sc = cur.sc - 1;
                temp.tr = cur.tr;
                temp.tc = cur.tc - 1;
                temp.d = cur.d;
                temp.cnt = cur.cnt + 1;
                queue.offer(temp);
                visited[temp.sr][temp.sc][temp.d] = true;
            }

            if (cr(cur) && !visited[cur.sr][cur.sc + 1][cur.d]) {
                Train temp = new Train();
                temp.fr = cur.fr;
                temp.fc = cur.fc + 1;
                temp.sr = cur.sr;
                temp.sc = cur.sc + 1;
                temp.tr = cur.tr;
                temp.tc = cur.tc + 1;
                temp.d = cur.d;
                temp.cnt = cur.cnt + 1;
                queue.offer(temp);
                visited[temp.sr][temp.sc][temp.d] = true;
            }

            if (ct(cur) && !visited[cur.sr][cur.sc + 1][(cur.d + 1) % 2]) {
                Train temp = new Train();

                if (cur.d == 0) {
                    temp.fr = cur.sr;
                    temp.fc = cur.sc - 1;
                    temp.tr = cur.sr;
                    temp.tc = cur.sc + 1;
                } else {
                    temp.fr = cur.sr - 1;
                    temp.fc = cur.sc;
                    temp.tr = cur.sr + 1;
                    temp.tc = cur.sc;
                }

                temp.sr = cur.sr;
                temp.sc = cur.sc;
                temp.d = (cur.d + 1) % 2;
                temp.cnt = cur.cnt + 1;

                queue.offer(temp);
                visited[temp.sr][temp.sc][temp.d] = true;
            }

        }

        System.out.println(answer);

        br.close();
    }

    static boolean cu(Train train) {
        if (train.fr - 1 >= 0 ) {
            if (train.d == 0
                    && map[train.fr - 1][train.fc] == 0) {
                return true;
            } else if (train.d == 1
                    && map[train.fr - 1][train.fc] == 0
                    && map[train.sr - 1][train.sc] == 0
                    && map[train.tr - 1][train.tc] == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean cd(Train train) {
        if (train.tr + 1 < N) {
            if (train.d == 0
                    && map[train.tr + 1][train.tc] == 0) {
                return true;
            } else if (train.d == 1
                    && map[train.fr + 1][train.fc] == 0
                    && map[train.sr + 1][train.sc] == 0
                    && map[train.tr + 1][train.tc] == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean cl(Train train) {
        if (train.fc - 1 >= 0) {
            if (train.d == 1
                    && map[train.fr][train.fc - 1] == 0) {
                return true;
            } else if (train.d == 0
                    && map[train.fr][train.fc - 1] == 0
                    && map[train.sr][train.sc - 1] == 0
                    && map[train.tr][train.tc - 1] == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean cr(Train train) {
        if (train.tc + 1 < N) {
            if (train.d == 1
                    && map[train.tr][train.tc + 1] == 0) {
                return true;
            } else if (train.d == 0
                    && map[train.fr][train.fc + 1] == 0
                    && map[train.sr][train.sc + 1] == 0
                    && map[train.tr][train.tc + 1] == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean ct(Train train) {
        int r = train.sr;
        int c = train.sc;

        if (train.d == 0 && c - 1 >= 0 && c + 1 < N) {
            if (map[r - 1][c - 1] == 1) {
                return false;
            } else if (map[r - 1][c + 1] == 1) {
                return false;
            } else if (map[r + 1][c - 1] == 1) {
                return false;
            } else if (map[r + 1][c + 1] == 1) {
                return false;
            } else if (map[r][c - 1] == 1) {
                return false;
            } else if (map[r][c + 1] == 1) {
                return false;
            }
        } else if (train.d == 1 && r - 1 >= 0 && r + 1 < N) {
            if (map[r - 1][c - 1] == 1) {
                return false;
            } else if (map[r - 1][c + 1] == 1) {
                return false;
            } else if (map[r + 1][c - 1] == 1) {
                return false;
            } else if (map[r + 1][c + 1] == 1) {
                return false;
            } else if (map[r - 1][c] == 1) {
                return false;
            } else if (map[r + 1][c] == 1) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }
}

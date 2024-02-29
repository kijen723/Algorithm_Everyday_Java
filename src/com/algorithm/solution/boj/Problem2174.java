package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 2174. 로봇 시뮬레이션 */
public class Problem2174 {
    static int A, B, N, M;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static class Robot{
        int r, c, dir;

        public Robot(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2174.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Robot[] robots = new Robot[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char str = st.nextToken().charAt(0);

            if(str == 'N') {
                robots[i] = new Robot(r, c, 0);
            } else if(str == 'E') {
                robots[i] = new Robot(r, c, 1);
            } else if(str == 'S') {
                robots[i] = new Robot(r, c, 2);
            } else if(str == 'W') {
                robots[i] = new Robot(r, c, 3);
            }
        }

        boolean checkOK = true;

        L: for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken()) - 1;
            char cmd = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                if (cmd == 'L') {
                    robots[idx].dir = (robots[idx].dir - 1 + 4) % 4;
                } else if(cmd == 'R') {
                    robots[idx].dir = (robots[idx].dir + 1) % 4;
                } else {
                    robots[idx].r += dir[robots[idx].dir][0];
                    robots[idx].c += dir[robots[idx].dir][1];

                    if (robots[idx].r < 0 || robots[idx].r >= A || robots[idx].c < 0 || robots[idx].c >= B) {
                        checkOK = false;
                        System.out.println("Robot " + (idx + 1) + " crashes into the wall");

                        break L;
                    }

                    for (int k = 0; k < N; k++) {
                        if (k == idx) {
                            continue;
                        }

                        if (robots[idx].r == robots[k].r && robots[idx].c == robots[k].c) {
                            checkOK = false;
                            System.out.println("Robot " + (idx + 1) + " crashes into robot " + (k + 1));

                            break L;
                        }
                    }
                }
            }
        }

        if (checkOK) {
            System.out.println("OK");
        }

        br.close();
    }
}

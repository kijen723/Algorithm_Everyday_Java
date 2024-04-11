package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 2655. 가장높은탑쌓기 */
public class Problem2655 {
    static class Box {
        int idx, u, h, w;

        Box(int idx, int u, int h, int w) {
            this.idx = idx;
            this.u = u;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2655.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[N + 1];
        boxes[0] = new Box(0, 0, 0, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(i, u, h, w);
        }

        Arrays.sort(boxes, (a, b) -> a.u - b.u);

        int[][] dp = new int[N + 1][2];
        int maxH = 0;
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i].w > dp[j][1]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + boxes[i].h);
                    dp[i][1] = boxes[i].w;

                    if (maxH < dp[i][0]) {
                        maxH = dp[i][0];
                        idx = i;
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (idx > 0) {
            if (maxH == dp[idx][0]) {
                list.add(boxes[idx].idx);
                maxH -= boxes[idx].h;
            }
            idx--;
        }

        System.out.println(list.size());

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        br.close();
    }
}

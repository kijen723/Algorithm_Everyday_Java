package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 5604. [Professional] 구간 합 */
public class Problem5604 {
    static long[] cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input5604.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            if (start == 0) {
                start = 1;
            }

            long value = 1;
            cnt = new long[10];

            while (start <= end) {
                while (start % 10 != 0 && start <= end) {
                    addCnt(start, value);
                    start++;
                }

                if (start > end) break;

                while(end % 10 != 9 && start <= end) {
                    addCnt(end, value);
                    end--;
                }

                long sub = (end / 10) - (start / 10) + 1;

                for (int i = 1; i < 10; i++) {
                    cnt[i] += value * sub;
                }

                value *= 10;
                start /= 10;
                end /= 10;
            }

            long answer = 0;

            for (int i = 1; i < 10; i++) {
                answer += i * cnt[i];
            }

            System.out.println("#" + tc + " " + answer);
        }

        br.close();
    }

    static void addCnt(long l, long value) {
        for (long i = l; i > 0; i /= 10) {
            cnt[(int) (i % 10)] += value;
        }
    }
}

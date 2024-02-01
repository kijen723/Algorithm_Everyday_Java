package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 12891. DNA 비밀번호 */
public class Problem12891 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input12891.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String inputStr = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] ess = new int[4];

        for (int i = 0; i < ess.length; i++) {
            ess[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] cnt = new int[4];
        int start = 0;
        int end = P;

        for (int i = start; i < end; i++) {
            if (inputStr.charAt(i) == 'A' ) {
                cnt[0]++;
            } else if (inputStr.charAt(i) == 'C' ) {
                cnt[1]++;
            } else if (inputStr.charAt(i) == 'G' ) {
                cnt[2]++;
            } else if (inputStr.charAt(i) == 'T' ) {
                cnt[3]++;
            }
        }

        while (true) {
            if (check(cnt, ess)) {
                answer += 1;
            }

            if (end == S) {
                break;
            }

            if (inputStr.charAt(start) == 'A' ) {
                cnt[0]--;
            } else if (inputStr.charAt(start) == 'C' ) {
                cnt[1]--;
            } else if (inputStr.charAt(start) == 'G' ) {
                cnt[2]--;
            } else if (inputStr.charAt(start) == 'T' ) {
                cnt[3]--;
            }

            start++;

            if (inputStr.charAt(end) == 'A' ) {
                cnt[0]++;
            } else if (inputStr.charAt(end) == 'C' ) {
                cnt[1]++;
            } else if (inputStr.charAt(end) == 'G' ) {
                cnt[2]++;
            } else if (inputStr.charAt(end) == 'T' ) {
                cnt[3]++;
            }

            end++;
        }

        System.out.println(answer);

        br.close();
    }

    private static boolean check(int[] cnt, int[] ess) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] < ess[i]) {
                return false;
            }
        }

        return true;
    }
}

package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 10162. 전자레인지 */
public class Problem10162 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input10162.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] buttons = {300, 60, 10};

        int[] answer = new int[3];

        answer[0] = T / buttons[0];
        T %= buttons[0];

        answer[1] = T / buttons[1];
        T %= buttons[1];

        answer[2] = T / buttons[2];
        T %= buttons[2];

        if (T == 0) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
        } else System.out.println(-1);

        br.close();
    }
}

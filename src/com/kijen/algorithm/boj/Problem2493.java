package com.kijen.algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* BOJ 2493. 탑 */
public class Problem2493 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input2493.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[buildings.length];
        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > buildings[i]) {
                    answer[i] = stack.peek()[1] + 1;

                    break;
                } else {
                    stack.pop();
                }
            }

            stack.add(new Integer[] {buildings[i], i});
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }

        br.close();
    }
}

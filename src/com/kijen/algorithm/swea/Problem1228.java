package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/* SWEA 1228. [S/W 문제해결 기본] 8일차 - 암호문1 */
public class Problem1228 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1228.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<String> pwStack = new Stack<>();
        Queue<String> cmQueue = new ArrayDeque<>();
        Stack<String> tempStack = new Stack<>();;
        String cm;
        int idx;
        int cnt;

        for (int tc = 1; tc < 11; tc++) {
            int pwLen = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            pwStack.clear();

            for (int i = 0; i < 10; i++) {
                pwStack.push(st.nextToken());
            }

            int cmLen = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cmLen; i++) {
                cm = st.nextToken();
                idx = Integer.parseInt(st.nextToken());
                cnt = Integer.parseInt(st.nextToken());
                cmQueue.clear();
                tempStack.clear();

                for (int j = 0; j < cnt; j++) {
                    cmQueue.offer(st.nextToken());
                }

                if (idx < 10) {
                    for (int j = 0; j < 10 - idx; j++) {
                        tempStack.push(pwStack.pop());
                    }
                }

                for (int j = 0; j < cnt; j++) {
                    if (pwStack.size() >= 10) {
                        break;
                    }

                    pwStack.push(cmQueue.poll());
                }

                while (pwStack.size() < 10) {
                    pwStack.push(tempStack.pop());
                }
            }

            System.out.print("#" + tc + " ");

            for (String str : pwStack) {
                System.out.print(str + " ");
            }

            System.out.println();
        }

        br.close();
    }
}

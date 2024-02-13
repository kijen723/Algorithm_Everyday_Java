package com.algorithm.solution.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/* JUNGOL 1828. 냉장고 */
public class Problem1828 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/jungol/Input1828.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] refrigerator = new int[N][2];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < refrigerator.length; i++) {
            st = new StringTokenizer(br.readLine());
            refrigerator[i][0] = Integer.parseInt(st.nextToken());
            refrigerator[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(refrigerator, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        stack.add(new int[] {refrigerator[0][0], refrigerator[0][1]});

        int[] cur;

        for (int i = 1; i < refrigerator.length; i++) {
            cur = stack.peek();

            if (cur[1] >= refrigerator[i][1]) {
                cur[0] = refrigerator[i][0];
                cur[1] = refrigerator[i][1];
                stack.pop();
                stack.add(cur);
            } else if (cur[1] >= refrigerator[i][0]) {
                    cur[0] = refrigerator[i][0];
                    stack.pop();
                    stack.add(cur);
            } else stack.add(new int[] {refrigerator[i][0], refrigerator[i][1]});
        }

        System.out.println(stack.size());

        br.close();
    }
}

package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/* SWEA 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기 */
public class Problem1218 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1218.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int strLen;
        String[] brackets;
        Stack<String> stack;

        for (int tc = 1; tc < 11; tc++) {
            strLen = Integer.parseInt(br.readLine());
            brackets = br.readLine().split("");
            stack = new Stack<>();

            stack.push(brackets[0]);

            for (int i = 1; i < strLen; i++) {
                if ((brackets[i].equals(">") && stack.peek().equals("<"))
                        || (brackets[i].equals("}") && stack.peek().equals("{"))
                        || (brackets[i].equals("]") && stack.peek().equals("["))
                        || (brackets[i].equals(")") && stack.peek().equals("("))) {
                    stack.pop();

                    continue;
                }

                stack.push(brackets[i]);
            }

            System.out.println("#" + tc + " " + (stack.size() > 0 ? 0 : 1));
        }

        br.close();
    }
}

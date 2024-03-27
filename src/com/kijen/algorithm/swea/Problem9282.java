package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 9282. 초콜릿과 건포도 */
public class Problem9282 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input9282.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {


            System.out.println("#" + tc + " ");
        }

        br.close();
    }
}

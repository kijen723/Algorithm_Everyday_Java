package com.kijen.algorithm.swea;

import java.io.*;
import java.util.*;

/* SWEA */
public class Problem {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {


            System.out.println("#" + tc + " ");
        }

        br.close();
    }
}

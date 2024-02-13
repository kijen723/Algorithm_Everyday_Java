package com.algorithm.solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* BOJ 3040. 백설 공주와 일곱 난쟁이 */
public class Problem3040 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/boj/Input3040.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int[] dwarfs = new int[9];

        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            total += dwarfs[i];
        }

        L : for (int i = 0; i < dwarfs.length - 1; i++) {
            for (int j = i + 1; j < dwarfs.length; j++) {
                if (total - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = dwarfs[j] = 0;
                    break L;
                }
            }
        }

        for (int dwarf : dwarfs) {
            if (dwarf != 0) System.out.println(dwarf);
        }

        br.close();
    }
}

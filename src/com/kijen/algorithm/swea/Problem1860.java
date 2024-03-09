package com.kijen.algorithm.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* SWEA 1860. 진기의 최고급 붕어빵 */
public class Problem1860 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input1860.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            input = br.readLine().split(" ");
            int[] customer = new int[N];

            for (int i = 0; i < customer.length; i++) {
                customer[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(customer);

            boolean flag = true;
            int time = -1;
            int count = 0;
            int idx = 0;

            while (idx < customer.length && flag) {
                time++;

                if(time % M == 0 && time != 0) {
                    count += K;
                }

                while (idx < customer.length) {
                    if (customer[idx] > time) {

                        break;
                    }

                    if (count == 0) {
                        System.out.printf("#%d Impossible\n", tc);
                        flag = false;

                        break;
                    }

                    idx++;
                    count--;
                }

            }

            if (flag) {
                System.out.printf("#%d Possible\n", tc);
            }
        }

        br.close();
    }
}

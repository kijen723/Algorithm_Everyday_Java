package com.algorithm.solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA 6808. 규영이와 인영이의 카드게임 */
public class Problem6808 {
    static int win, lose, myScore, yourScore;
    static int[] myCards = new int[9], yourCards = new int[9], shuffleCards = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/swea/Input6808.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int idx;
        boolean[] check;

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            check = new boolean[18];

            for (int i = 0; i < myCards.length; i++) {
                myCards[i] = Integer.parseInt(st.nextToken());
                check[myCards[i] - 1] = true;
            }

            idx = 0;

            for (int i = 0; i < 18; i++) {
                if (!check[i] && idx < yourCards.length) yourCards[idx++] = i + 1;
            }

            win = lose = 0;

            calcWinLose(0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }

        br.close();
    }

    private static void calcWinLose(int depth) {
        if (depth == yourCards.length) {
            myScore = yourScore = 0;

            for (int i = 0; i < myCards.length; i++) {
                if (myCards[i] > shuffleCards[i]) myScore += myCards[i] + shuffleCards[i];
                else if (myCards[i] < shuffleCards[i]) yourScore += myCards[i] + shuffleCards[i];
            }

            if (myScore > yourScore) win++;
            else if (myScore < yourScore) lose++;

            return;
        }

        for (int i = 0; i < yourCards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                shuffleCards[depth] = yourCards[i];
                calcWinLose(depth + 1);
                visited[i] = false;
            }
        }
    }
}

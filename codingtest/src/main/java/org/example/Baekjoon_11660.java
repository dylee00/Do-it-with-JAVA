package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //2차원 배열의 크기 N
        int N = Integer.parseInt(st.nextToken());
        //구간 합 질의의 개수
        int M = Integer.parseInt(st.nextToken());

        //구간합을 저장하는 2차원 배열
        long Sum[][] = new long[N + 1][N + 1];

        //for loop를 돌며 입력받은 값을 저장
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < N + 1; j++) {
                if (j == 1) {
                    Sum[i][j] = Integer.parseInt(st.nextToken()) + Sum[i - 1][N];
                } else {
                    Sum[i][j] = Integer.parseInt(st.nextToken()) + Sum[i][j - 1];
                }
            }
        }

        //입력받은 구간합 구하기
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(bf.readLine());
            int i_1 = Integer.parseInt(st.nextToken());
            int j_1 = Integer.parseInt(st.nextToken());
            int i_2 = Integer.parseInt(st.nextToken());
            int j_2 = Integer.parseInt(st.nextToken());
            if (j_1 == 1) {
                i_1 = i_1 - 1;
                j_1 = N;
            }
            System.out.println(Sum[i_2][j_2] - Sum[i_1][j_1]);
        }
    }
}

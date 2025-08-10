package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //재료의 개수
        int N = Integer.parseInt(st.nextToken());

        long arr[] = new long[N];

        st = new StringTokenizer(bf.readLine());
        //a+b의 합
        long M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        //long형 배열에 재료들 고유번호 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //배열 정렬
        Arrays.sort(arr);
        //투포인터 이동을 이용하여 배열의 index가 a<b인 동안 순회
        int a = 0; //맨 처음 인덱스
        int b = N-1; //맨 마지막 인덱스
        long sum = arr[a] + arr[b];
        int count = 0;

        while (a < b) {
            if (sum < M) {
                a++;
                sum = arr[a] + arr[b];
            } else if (sum > M) {
                b--;
                sum = arr[a] + arr[b];
            } else {
                count++;
                a++;
                b--;
                sum = arr[a] + arr[b];
            }
        }

    }
}

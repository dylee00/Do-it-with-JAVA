package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //숫자의 개수
        int N = Integer.parseInt(st.nextToken());

        //크기가 N인 배열 생성
        long arr[] = new long[N];

        st = new StringTokenizer(bf.readLine());
        //입력된 숫자를 arr[]에 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //arr정렬
        Arrays.sort(arr);

        //투포인터 알고리즘을 이용하여 배열 순회
        //순회를 안한 숫자 중 제일 큰 숫자의 합이 되는 배열의 인덱스가 있다면 Count++
        int count = 0;
        int M = 1;
        while (N > M ) {
            long sum = arr[N - M];
            int a = 0;
            int b = N-M-1;
            while (a < b) {
                if (sum > arr[a] + arr[b]) {
                    a++;
                } else if (sum < arr[a] + arr[b]) {
                    b--;
                } else {
                    count++;
                    break;
                }
            }
            M++;
        }
        System.out.println(count);
        bf.close();
    }
}

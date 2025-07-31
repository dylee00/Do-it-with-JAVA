package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_11659 {
    public static void main(String[] args) throws IOException {
        //bufferedReader로 읽고
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer로 string으로 한 줄씩 읽어와 integer로 한 개(토큰 한개)씩 파싱
        StringTokenizer stringToknizer = new StringTokenizer(bufferedReader.readLine());

        //숫자 개수 N
        int N = Integer.parseInt(stringToknizer.nextToken());
        //구간합 구해야 하는 횟수 M
        int M = Integer.parseInt(stringToknizer.nextToken());

        //for loop돌면서 배열에 입력받은 숫자 저장 후 구간합 구하기
        //입력받은 숫자를 저장하는 배열Num
        int Num[] = new int[N];
        //구간합을 저장하는 배열 Sum
        long Sum[] = new long[N+1];

        //첫 번째 인덱스 저장
        stringToknizer = new StringTokenizer(bufferedReader.readLine());
        Num[0] = Integer.parseInt(stringToknizer.nextToken());
        Sum[0] = Num[0];

        //두 번째 인덱스부터 끝까지 저장하며 동시에 구간합 구하기
        for (int k = 1; k < Num.length; k++) {
            Num[k] = Integer.parseInt(stringToknizer.nextToken());
            Sum[k] = Sum[k - 1] + Num[k];
        }


        //M만큼 for loop를 반복하며 i번째 수에서 j번째 구간까지의 합 출력
        for (int p = 0; p < M; p++) {
            stringToknizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringToknizer.nextToken());
            int j = Integer.parseInt(stringToknizer.nextToken());
            System.out.println(Sum[j]-Sum[i-1] + "\n");
        }

    }
}

//1. scanner가 문제였나? -> 맨 앞의 숫자만 들어가고 그 뒤의 숫자는 배열에 들어가지 않음
//여러 개의 숫자를 입력 받을때는 scanner말고 bufferedReader과 Tokenizer 사용하기
//많은 개수의 숫자를 입력받을때는 StringTokenizer로 받아 한 개씩 분배
//Sum배열로만 해결 가능. Num[]은 없어도 될듯
//주어진 구간을 보고 배열의 인덱스 어케 설정할지 생각하기..
package org.example;

import java.util.Scanner;

public class Baekjoon_15649_practice {
    static int N,M;
    static boolean[] V; //visit 배열
    static int[] S; //수열 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = new int[N];
        V = new boolean[N];
        //백트래킹 실행
        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == M) { //정답인지 확인 후 리턴
            //수열 출력
            printArray();
            return;
        }
        //가지치기
        for (int i = 0; i < N; i++) { //갈수 있는 모든 선택지
            if (!V[i]) {
                V[i] = true; //visit배열에 사용했다고 표시
                S[length] = i; //수열에 숫자 추가
                backtracking(length + 1); //input으로 들어가는 수열의 길이를 +1(한개 방문했으니까)
                V[i] = false; //백트래킹을 빠져 나오고 사용 표시 제거(다시 뒤로 감)
            }
        }
    }

    private static void printArray() {
        for(int i = 0; i < N; i++){
            System.out.print(S[i] + 1 + " ");
            //print ->줄바꿈 x
            //println -> 줄바꿈 o
        }
    }
}

/*
N,M(1~N 까지 자연수를 선택하여 길이가 M인 수열 모두 구하기)
V(숫자 사용 여부 저장 배열)
S(수열 정보 저장 배열)
백트래킹 실행(매개변수: 수열의 길이)

backtracking(수열 길이) {
    if(길이가 M인 수열 만들어짐)
        return 수열 정보 + 함수 반환
     for(1~N까지 자연수 탐색) {
        if(아직 수열에 포함되지 않은 수)
        V 배열에 수 사용 표시
        수열에 수 추가
        수열 길이는 1 증가시키고 backtracking 함수 재호출
        V 배열에 수 사용 표시 제거
     }
}
*
*
*
* */
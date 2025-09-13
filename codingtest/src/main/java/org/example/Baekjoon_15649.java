package org.example;

import java.util.Scanner;

public class Baekjoon_15649 {
    static boolean[] visit; //방문
    static int[] arr; //수열
    static int N, M;
    public static void main(String[] args) {
        Scanner Sc = new  Scanner(System.in);
        N = Sc.nextInt(); //숫자의 범위
        M = Sc.nextInt(); //수열의 길이

        visit = new boolean[N];
        arr = new int[M];

        backtracking(0);


    }

    public static void backtracking(int length) {
        if (length == M) {
            printArray();
            System.out.print("\n");
            return;
        }
        for(int i=0;i< N;i++){
            if (!visit[i]) { //i를 방문하지 않았다면 방문하기
                visit[i] = true;
                arr[length] = i;
                backtracking(length+1);
                visit[i] = false; //백트래킹 빠져 나오면서 방문배열 false
            }
        }
    }
    public static void printArray() {
        for(int i=0;i< M;i++){
            System.out.print(arr[i] + 1 + " ");
        }

    }
}

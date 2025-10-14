package org.example;

import java.util.Scanner;

public class Baekjoon_11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;
        for(long p=2;p<=Math.sqrt(n);p++){ //제곱근까지만 진행
            if (n % p == 0) { //p가 n의 소인수인지 확인
                result = result/p; //오일러의 피로 결과값 업데이터
                while (n % p == 0) { //현재 계산한 소인수 제거
                    n = n/p;
                }
            }
        }
        if (n > 1) { //아직 소인수가 남아 있다면
            result = result/n;
        }
        System.out.println(result);
    }
}

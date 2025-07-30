package org.example;

import java.util.Scanner;

//먼저 문제 내용을 확인하고 분석한 후 코딩하기
public class Baekjoon_11720_refactor {

    //방법 1(내 풀이)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //숫자의 개수
        int score = sc.nextInt();
        //숫자 n개를 문자열로 받음
        String num = sc.next();
        //합을 저장할 변수 선언 및 초기화
        int sum = 0;

        //score만큼 반복
        for (int i = 0; i < score; i++) {
            //문자열을 char로 변경
            char c = num.charAt(i);
            //아스키 코드를 이용하여 문자를 숫자로 변경
            sum += c - '0';
        }

        System.out.println(sum);
    }

    //방법 2(답지 풀이)
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //숫자의 개수
//        int score = sc.nextInt();
//        //숫자 n개를 문자열로 받음
//        String num = sc.next();
//        char[] Num = num.toCharArray();
//        //합을 저장할 변수 선언 및 초기화
//        int sum = 0;
//
//        //score만큼 반복
//        for (int i = 0; i < Num.length; i++) {
//            //문자 배열에서 해당 인덱스의 문자를 가져옴
//            char c = Num[i];
//            //아스키 코드를 이용하여 문자를 숫자로 변경
//            sum += c - '0';
//        }
//
//        System.out.println(sum);
//    }
}

//string.toCharArray() method -> string을 char배열로 변경
//string.charAt(i) -> string의 i번째 인덱스 원소를 char로 변경
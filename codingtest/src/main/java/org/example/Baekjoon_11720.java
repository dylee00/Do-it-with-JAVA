package org.example;

import java.util.Scanner;

public class Baekjoon_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //count를 받아 배열 생성
        int count = scanner.nextInt();
        int C[] = new int[count];

        //num을 받아 저장
        int num = scanner.nextInt();
        scanner.close();

        //num의 나머지는 배열에 저장, num의 몫은 나누면서 계속 갱신
        //문제점 -> 이렇게 하면 100자리 숫자는 받을 수 없음(int long형으로 숫자를 받을 수 없음)
        for (int i = 0; i < count-1; i++) {
            int temp = 0;
            temp = num % 10;
            C[i] = temp;
            num = num /10;
        }

        //마지막 인덱스의 값은 num
        C[count-1] = num;

        //배열을 순회하면서 값 더하기
        int result = 0;
        for (int j = 0; j < count; j++) {
            result += C[j];
        }

        System.out.println(result);

    }
}

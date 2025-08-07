package org.example;

import java.util.Scanner;

public class Baekjoon_1160 {
    public static void main(String[] args) {
        //입력받은 자연수 저장
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //count, start_index, end_index, sum 초기화
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (start_index != n) {
            if (n > sum) {
                end_index++;
                sum += end_index;
            } else if (n < sum) {
                sum -= start_index;
                start_index++;
            } else {
                count++;
                end_index++;
                sum += end_index;
            }
        }
    }
}

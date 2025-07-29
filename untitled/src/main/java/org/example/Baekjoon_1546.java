package org.example;

import java.util.Scanner;

public class Baekjoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //과목 개수
        int num = sc.nextInt();
        //시험 성적 저장하는 배열 -> 결과에 소수점 포함이라 float로 선언
        double Score[] = new double[num];
        //시험 성적 저장
        for (int i = 0; i < Score.length; i++) {
            Score[i] = sc.nextInt();
        }
        //최댓값 구하기
        double max = 0;
        for (int i = 0; i < Score.length; i++) {
            if (max < Score[i]) {
                max = Score[i];
            }
        }

        float sum = 0;
        //평균 구하기
        for (int i = 0; i < Score.length; i++) {
            sum += (Score[i]/max)*100;
        }

        sum = sum / Score.length;

        System.out.println(sum);

    }
}



package org.example;

import java.util.Scanner;

public class Baekjoon_1546_refactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int Num[] = new int[num];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < Num.length; i++) {
            Num[i] = sc.nextInt();
            if (Num[i]> max) {
                max = Num[i];
            }
            sum += Num[i];
        }
        System.out.println(sum*100.0/max/num);
    }
}

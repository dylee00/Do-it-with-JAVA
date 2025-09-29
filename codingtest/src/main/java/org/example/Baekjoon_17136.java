package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17136 {
    static int[][]M = new int[10][10];
    static int[] S = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE; //최소 사용 업데이트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0); //좌표, 색종이 몇개 썼는지
        if (result == Integer.MAX_VALUE) { //result가 update되지 않음 -> 경우의 수가 존재하지 않음 -> -1 리턴
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
    private static void backtracking(int xy, int count) {
        //정답처리
        if (xy == 100) {
            result = Math.min(result, count); //count로 result update
            return;
        }
        //가지치기
        int x = xy % 10;
        int y = xy / 10;
        if(result <= count) return;
        if (M[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                //종이 확인
                if(S[i] > 0 && check(x,y,i)) {
                    S[i]--; //색종이 사용
                    fill(x,y,i,0); //1을 0으로 변경
                    backtracking(xy+1, count+1); //벡트래킹
                    fill(x,y,i,1); //0을 1으로 변경
                    S[i]--;
                }

            }
        } else {
            backtracking(xy+1, count);
        }
    }

    //num으로 배열의 범위만큼 숫자를 바꾸기
    private static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                M[i][j] = num;
            }
        }

    }

    //색종이를 붙일 수 있는지 없는지 판별하는 함수
    private static boolean check(int x, int y, int size) {
        if(x + size > 10 || y + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(M[i][j] != 1) return false; //색종이 붙일 수 없으면 false
            }
        }
        return true;
    }
}

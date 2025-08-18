package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Remote;
import java.util.StringTokenizer;

public class Beakjoon_12981 {

    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); //dna 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); //부분 문자열의 길이(윈도우)
        int Result = 0;
        char A[] = new char[S]; //dna 문자열을 저장할 배열
        checkArr = new int[4]; //비밀번호 체크 배열 -> 비밀번호 문자 A,C,G,T 순서대로 개수 저장
        myArr = new int[4]; //부분 문자열의 A,C,G,T 개수를 저장하는 배열
        checkSecret = 0; //몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수

        A = bf.readLine().toCharArray(); //문자열 저장

        //checkArr에 비밀번호 문자 조건인 A,C,G,T 개수 저장
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++; //A,C,G,T에서 문자의 개수가 맞아야 하는데 0이면 체크할 필요 없으니까 checkSecret++, checkSecret = 4면 모두 충족
            }
        }

        //초기 부분문자열 P 처리
        //부분 문자열 세팅
        for (int i = 0; i < P; i++) {
            //a라는 문자열을 myArr에 넣고 + checkSecret update 필요 -> 함수로
            Add(A[i]); //i번째 문자의 값을 판단 후 현재 상태 배열인 myArr에 넣고, checkSecret 갱신
        }

        if (checkSecret == 4) { //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
            Result++;
        }

        //슬라이딩 윈도우
        for (int i = P; i < S;i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result++;
            }

        }

    }

    //제거되는 문자 처리
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
            case 'G':
            case 'T':

        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    checkSecret++;
                break;

            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    checkSecret++;
                break;

            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    checkSecret++;
                break;

            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    checkSecret++;
                break;


        }
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Baekjoon_11004 {
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //숫자 개수
        int N =  Integer.parseInt(st.nextToken());
        //k번째 수
        int K = Integer.parseInt(st.nextToken());

        int A[] = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
           A[i] = Integer.parseInt(st.nextToken());

        }

        //퀵소트 실행
        // parameter -> 배열, 첫 번째 인덱스, 마지막 인덱스, k번째 수의 인덱스
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        //첫 번째 인덱스보다 마지막 인덱스가 크다면
        if (S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K) return;
            else if (K < pivot) {
                quickSort(A, S, pivot - 1, K); //K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
            } else { //k가 pivot보다 크면 오른쪽 그룹만 정렬 수행
            quickSort(A, pivot + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int M = (S+E)/2;
        swap(A, S, M); //중앙값을 1번째 요소로 이동
        int pivot = A[S];
        int i = S;
        int j = E;
        while (i < j) {
            while (pivot < A[j]) { //pivot보다 작은 수가 나올 때까지 j--
                j--;
            }
            while (i < j && pivot >= A[i]) { //pivot보다 큰 수가 나올 때까지 i++
                i++;
            }
            swap(A, i, j); //찾은 i와 j를 교환
        }
        // i == j pivot의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}


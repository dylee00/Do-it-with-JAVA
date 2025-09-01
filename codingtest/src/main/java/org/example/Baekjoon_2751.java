package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon_2751 {
    //전역 변수로 지정(재귀함수 사용)
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        //인덱스 계산의 편의성을 위해 N+1 길이의 배열 생성
        //알고리즘 문제에서는 1-based가 편리
        A = new int[N+1];
        tmp = new int[N+1];
        for(int i = 1; i <= N; i++){ //중간값을 계속 구하고 + 인덱스도 계속 써야 함 -> N+1로 쓰는게 나을려나?
            A[i] = Integer.parseInt(br.readLine());
        }
        //병합 정렬 수행
        merge_sort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e) {
        //구간의 크기가 2 또는 1이라면
        if(e-s < 1) return;
        //imt m = (s+e)/2 -> int 초과할수도 있어서 동치 식인 s + (e-s)/2를 사용
        int m = s + (e-s)/2;

        //이전 구간들 sort
        merge_sort(s, m);
        merge_sort(m + 1, e);

        //tmp에 배열 저장
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s; //왼쪽 구간 시작점
        int index2 = m+1; //오른쪽 구간 시작점

        //두 그룹 병합
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] < tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        //남은 그룹 정리
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}

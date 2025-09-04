package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon_10989 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        //기수정렬 함수 (배열 크기, 자릿수)
        Radix_sort(N, 5);
        for(int i = 0; i < N; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void Radix_sort(int N, int K){
        //합 배열 -> 자릿수 분포를 합으로 저장
        int[] bucket = new int[10];
        //정렬 결과 임시 저장 배열
        int[] output = new int[N];
        //현재 자릿수
        int jarisu = 1;
        int count = 0;
        while (count != K) {
            //자릿수 세기 -> 센 다음 bucket에 Push
            for(int i = 0; i < N; i++){
                int k = (arr[i] /jarisu) % 10;
                bucket[k]++;
            }
            //누적 합 배열로 변경 -> 나중에 output에서 원소 넣을 때 사용
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            //해당 자릿수 정렬
            //같은 키 값을 가진 원소들의 순서를 유지하기 위해 뒤쪽부터 처리
            for(int i = N-1; i >= 0; i--){

                //합 배열을 이용하여 구해진 bucket를 통해 arr[i]가 들어갈 output 인덱스 계산
                output[bucket[(arr[i] / jarisu % 10)]-1] = arr[i];
                //output배열 숫자 삭제
                bucket[(arr[i] /jarisu) % 1]--;
            }
            for(int i = 0; i < N; i++){
                arr[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }


    }
}

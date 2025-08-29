package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine()); //배열 크기
        int arr[] =new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열 받아서 저장
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        quickSort(arr,0,n-1);

    }

    public static void quickSort(int[] arr, int start, int end) {

        //퀵 정렬 수행
        if (start >= end) {
            System.out.println("end");
            return;
        }

        //pivot, 왼쪽 값, 오른쪽 값 설정
        int pivot = start;
        int lo = start + 1; //왼쪽 배열
        int hi = end; //오른쪽 배열

        while(lo<=hi){
            //lo에서 pivot보다 큰 값을 만날 때까지 반복
            while (lo <= end && arr[lo] <= arr[pivot]) {
                lo++;
            }
            //hi에서 pivot보다 작은 값을 만날 때까지 반복
            while(hi > start && arr[hi] >= arr[pivot]) {
                hi--;
            }
            //서로 엇갈림 -> lo는 pivot보다 큰 값, hi는 pivot보다 작은 값
            //hi와 pivot 교체
            if (lo > hi) { //
                int temp = arr[hi];
                arr[hi] = arr[pivot];
                arr[pivot] = temp;
            } //엇갈리지 않음 -> lo는 pivot보다 큰 값, hi는 pivot보다 작은 값, lo와 hi 교체
            else {
                int temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
            }

            // 엇갈렸을 경우,
            // 피벗값과 hi값을 교체한 후 해당 피벗을 기준으로 앞 뒤로 배열을 분할하여 정렬 진행
            quickSort(arr, start,hi-1);
            quickSort(arr,hi+1,end);

        }
    }
}

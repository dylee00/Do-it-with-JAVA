package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //버블정렬 -> 앞쪽부터 고정
        for(int k=0;k<N;k++){
            for(int j=k+1;j<N;j++){
                if(arr[k]>arr[j]){
                    int temp=arr[k];
                    arr[k]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
    }
}

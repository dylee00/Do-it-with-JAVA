package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beakjoon_11286 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //연산의 개수
        int N = Integer.parseInt(bf.readLine());

        //우선순위 queue
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1,  o2) -> {
            //o1 과 o2의 값이 다른 경우 -> 절댓값이 큰 것이 우선순위가 더 낮음
            //o1 > o2라면 swap이 일어남 -> o1-o2 < 0일때 우선순위 큐 swap
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            //절댓값이 같다면
            if(first == second){
                //음수의 우선순위가 더 높음
                if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return first - second;


        });


        //N번 순회하며 입력값을 받기
        for (int i = 0; i < N; i++) {
            int input  = Integer.parseInt(bf.readLine());
            //input = 0이라면
            if (input == 0) {
                //우선순위 queue가 비어있다면
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(input);
            }
        }

    }
}

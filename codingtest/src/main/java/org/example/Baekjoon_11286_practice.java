package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_11286_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        //우선순위 큐 선언
        //비교할 객체 2개 선언(o1,o2)
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            //절댓값이 작은 데이터 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            //절댓값이 같은 경우 음수 우선
            if(first_abs == second_abs){
                return o1 > o2 ? 1: -1; //o1> o2라면 1, 아니라면 -1
            }
            return first_abs - second_abs;
            //양수 리턴-> o1과 o2를 swap 하지 않음 ,음수 리턴 -> o1과 o2를 swap함

        });

        for (int i = 0; i < N; i++) {
            int request =  Integer.parseInt(bf.readLine());
            if (request == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }




    }

}
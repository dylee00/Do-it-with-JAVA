package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //버블정렬 -> O(n^2)
        Scanner scanner = new Scanner(System.in); //scanner는 한 번만 생성해서 객체를 재사용 하기
        int index = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < index; i++){
            int inputInteger = scanner.nextInt();
            arr.add(inputInteger);
        }

        //정렬
        for (int j = 0; j < arr.size() - 1; j++) {
            for (int k = j + 1; k < arr.size(); k++) {
                if (arr.get(j) > arr.get(k)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(k));
                    arr.set(k,temp);
                }
            }
        }

        //출력
        for (int p = 0; p < arr.size(); p++) {
            System.out.println(arr.get(p));
        }

        scanner.close();
    }


}

//java arrayList에서 값 가져옴 -> get(index)
//값 변경 -> set(index, 바꿀 값)
//값 삭제 -> remove(index)
//scanner -> scanner객체 한 번만 생성해서 재사용 한 다음 loop가 끝날 때 close()해주기
//사용 방식
// 1. scanner 객체 생성 -> Scanner scanner = new Scanner(System.in);
// 2. 객체를 사용하여 작업(여기서는 int로 받은 값을 변경) -> int input = scanner.nextInt();
// 3. scanner 할당 해제 -> scanner.close();


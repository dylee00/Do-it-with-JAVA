import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int numbers[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));
        numbers = new int[n+1];

        //n+1개의 집합 초기화 -> Key, value 모두 index에 해당하는 값
        for (int i = 1; i < n+1; i++) {
            numbers[i] = i;
        }

        //m번 연산 반복
        for(int count=0;count<m;count++){

            //연산, 숫자 1, 숫자 2 저장
            st = new StringTokenizer(br.readLine());
            int calculation = Integer.parseInt(st.nextToken(" ")); //연산 타입
            int firstNumber = Integer.parseInt(st.nextToken(" ")); //숫자 1
            int secondNumber = Integer.parseInt(st.nextToken(" ")); //숫자 2

            //0 -> 합집합
            if (calculation == 0) {
                union(firstNumber, secondNumber);
            }
            //1 -> find
            else {
                if (checkSame(firstNumber, secondNumber)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int firstNumber, int secondNumber) { //대표 노드끼리 연결
        firstNumber = find(firstNumber);
        secondNumber = find(secondNumber);
        if(firstNumber != secondNumber){
            numbers[secondNumber] = firstNumber;
        }
    }

    public static int find(int number) { //find연산 -> 해당 숫자의 대표 노드 찾기
        if (numbers[number] == number) {
            return number;
        } //대표 노드를 찾지 못했다면 value의 대표 노드를 찾을 때 까지 반복
        else {
            return numbers[number] = find(numbers[number]);
        }
    }
    
    public static boolean checkSame(int firstNumber, int secondNumber) {
        firstNumber = find(firstNumber);
        secondNumber = find(secondNumber);
        if (firstNumber == secondNumber) {
            return true;
        }
        return false;
    }
}
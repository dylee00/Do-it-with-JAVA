import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        //10^14를 모두 넣으면 시간 초과(2억번 이상의 연산) -> 10^14의 제곱근까지의 소수를 구한 다음, 이 소수들의 제곱근이 Min~Max사이에 있는지 파악
        //소수 판별
        long Arr[] = new long[10000001];
        for (int i = 2; i < Arr.length; i++) {
            Arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(Arr.length); i++) {
            if (Arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < Arr.length; j = j + i) {
                Arr[j] = 0;
            }
        }
        //거의 소수 구하기
        int count = 0;
        for(int i=2;i<Arr.length;i++){
            if (Arr[i] != 0) {
                long temp = Arr[i];
                //temp 제곱근이 Max와 Min 사이인지 파악
                while ((double) Arr[i] <= (double) Max / (double) temp) { //현재 소수 제곱근 <= MAX -> 값 안넘어가게 이항정리
                    if ((double) Arr[i] >= (double) Min / (double) temp) { //현재 소수 제곱근 >= MIN
                        count++;
                    }
                    temp = temp*Arr[i];
                }
            }
        }
        System.out.println(count);
    }

}

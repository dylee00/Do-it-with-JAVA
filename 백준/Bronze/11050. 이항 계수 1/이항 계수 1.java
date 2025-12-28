import java.util.Scanner;

public class Main {
    static int binomialArray[][];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        binomialArray = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            binomialArray[i][i] = 1;
            binomialArray[i][0] = 1;
            binomialArray[i][1] = i;
        }

        for(int i = 2; i <= N; i++){
            for(int j =2; j < i; j++){
                binomialArray[i][j] = binomialArray[i-1][j-1] + binomialArray[i-1][j];
            }
        }

        System.out.println(binomialArray[N][K]);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        String A[] = str.split("-");
        int result = 0;
        for(int i=0;i<A.length;i++){
            String s = A[i];
            int sum = changeStrToNum(s);
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
    private static int changeStrToNum(String s) {
        String S[] = s.split("[+]");
        int sum = 0;
        for(int i=0;i<S.length;i++){
            sum += Integer.parseInt(S[i]);
        }
        return sum;
    }
}

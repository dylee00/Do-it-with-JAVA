import java.util.Scanner;

public class Main {
    static long tree[];
    static int exponent;
    static int N, M, K;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        exponent = 1;
        while (exponent < N) {
            exponent *= 2;
        }

        tree = new long[exponent * 2];

        // 리프 노드에 값 저장
        for (int i = 0; i < N; i++) {
            tree[exponent + i] = sc.nextLong();
        }

        // parent node 채우기
        makeParentNodes();

        // M+K번 처리
        for (int t = 0; t < M + K; t++) {
            int a = sc.nextInt();
            long b = sc.nextLong();
            long c = sc.nextLong();

            if (a == 1) {
                changeNode((int)(b - 1), c);
            } else if (a == 2) {
                addNodes((int)(b - 1), (int)(c - 1));
            }
        }
    }

    public static void makeParentNodes() {
        for (int i = exponent - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public static void changeNode(int index, long value) {
        int changeIndex = exponent + index;
        tree[changeIndex] = value;
        
        // 부모 노드들 업데이트
        while (changeIndex > 1) {
            changeIndex /= 2;
            tree[changeIndex] = tree[changeIndex * 2] + tree[changeIndex * 2 + 1];
        }
    }

    public static void addNodes(int left, int right) {
        int start = exponent + left;
        int end = exponent + right;
        long sum = 0;

        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }

        System.out.println(sum);
    }
}
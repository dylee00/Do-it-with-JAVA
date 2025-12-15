import java.util.Scanner;

public class Main {
    static int[][] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];
        for(int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            //부모노드 인덱스
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            //자식 노드 x -> -1 저장
            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            //자식 노드 x -> -1 저장
            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int level){
        if (level == -1) {
            return;
        }
        System.out.print((char) ('A' + level)); //현재노드 출력
        preOrder(tree[level][0]);  //왼쪽 노드 탐색
        preOrder(tree[level][1]);   //오른쪽 노드 탐색
    }

    public static void inOrder(int level){
        if(level == -1) { //자식 노드 없으면 return
            return;
        }
        inOrder(tree[level][0]); //왼쪽노드 탐색
        System.out.print((char) ('A' + level)); //현재노드
        inOrder(tree[level][1]); //오른쪽 노드

    }

    public static void postOrder(int level){
        if(level == -1) {
            return;
        }
        postOrder(tree[level][0]); //왼쪽 탐색
        postOrder(tree[level][1]); //오른쪽 탐색
        System.out.print((char) ('A' + level)); //현재 노드
    }
}


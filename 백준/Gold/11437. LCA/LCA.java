import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree; //인접 리스트 저장
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //노드 개수
        tree = new ArrayList[N + 1];
        //tree 리스트 초기화
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        // tree 리스트에 데이터 저장
        //edge는 1개 더 작으니까 N-1
        for (int i = 0; i < N - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        //tree를 첫 번째 노드부터 BFS -> 부모노드, depth 저장
        BFS(1);

        //LCA
        int M =sc.nextInt();
        for (int i = 0; i < M; i++) {
            //공통 조상 구할 두 노드
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = extractLCA(a, b);
            System.out.println(LCA);
        }
    }

    private static void BFS(int node){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1; //depth가 같은 노드들의 수(탐색해야 하는 노드 수)
        int count = 0; //현재까지 탐색한 노드 수
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            //현재 노드와 연결된 노드 탐색(현재 노드의 바로 자식 노드들 탐색)
            for (int next : tree[now_node]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node;
                    depth[next] = level;
                }
            }
            count++;
            if (now_size == count) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }

    private static int extractLCA(int a, int b){
        //depth 확인
        // a > b 일때 맞춰서 진행
        if(depth[a] < depth[b]){
          int temp = a;
          a = b;
          b = temp;
        }
        while(depth[a] != depth[b]){ //두 노드의 depth 맞추기
            a = parent[a];
        }
        //같은 조상이 나올 때 까지 한 칸씩 올리기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
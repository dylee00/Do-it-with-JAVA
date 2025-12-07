import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int V,E,K; //정점 V, 간선 E, 시작 K
    public static int distance[]; //거리 저장 배열
    public static boolean visited[]; //방문 배열
    public static ArrayList<Edge> list[]; //그래프 저장 리스트
    public static PriorityQueue<Edge> pq =  new PriorityQueue<>(); //우선순위 큐 -> Edge의 value가 작은 순서대로 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점, 간선, 시작노드 입력 받기
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        //배열, 리스트 초기화
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        //edge 형태의 원소를 가지는 ArrayList 초기화
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }

        //거리 배열 초기화
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++) { //list에 값 넣기
            st = new StringTokenizer(br.readLine());
            int u  = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        //시작 노드부터 순회 시작
        pq.add(new Edge(K, 0)); //노드, 시작 노드부터 현재 노드까지의 거리
        distance[K] = 0;
        while (!pq.isEmpty()) {
            Edge current =  pq.poll();
            int currentVertex  = current.vertex;
            if(visited[currentVertex]) continue; //이미 방문한 노드는 다시 큐에 넣지 않음
            visited[currentVertex] = true;
            //현재 노드와 연결된 원소들 순회해서 최단 거리 업데이트
            for(int i=0;i<list[currentVertex].size();i++) {
                Edge tmp = list[currentVertex].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                //최단 거리로 업데이트
                if(distance[next] > distance[currentVertex] + value) {
                    distance[next] = distance[currentVertex] + value;
                    pq.add(new Edge(next, distance[next]));
                }
            }
        }
        //거리 출력
        for(int i = 1; i <= V; i++) {
            //방문했다면 거리 출력
            if(visited[i]) {
                System.out.println(distance[i]);
            }
            //방문하지 않았다면 INF 출력
            else  {
                System.out.println("INF");
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex,value;
    public Edge(int v,int e){
        vertex=v;
        value=e;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}

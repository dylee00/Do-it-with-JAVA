package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_11724_pracitce {
    static ArrayList<Integer> [] A; // 그래프 저장 배열
    static boolean visited[]; // 방문 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //노드 -> n, 엣지 -> m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        //인접 리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        //인접 리스트에 그래프 데이터 저장 -> edge 정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //방향이 없으므로 두 방향 모두 저장
            A[s].add(e);
            A[e].add(s);
        }
        //dfs 수행 개수
        int count = 0;
        //n의 개수만큼 순회 반복
        for(int i = 1; i <n + 1; i++){
            //방문하지 않은 노드가 없을 때 까지 반복
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }
    //DFS함수
    static void DFS(int i){
        //현재 노드가 방문 노드라면 return
        if(visited[i]) return;
        //현재 노드가 방문 노드가 아니라면
        visited[i] = true;

        //현재 노드에서 연결되어 있는 노드들을 모두 탐색
        for(int k : A[i]) {
            //탐색하지 않은 노드가 있다면 그 노드 순회
            if(!visited[k]){
                DFS(k);
            }
        }


    }
}

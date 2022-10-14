import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    // 정점 개수
        int m = Integer.parseInt(st.nextToken());    // 간선 개수
        int v = Integer.parseInt(st.nextToken());     // 탐색 시작 번호

        visited = new boolean[n + 1];

        for (int i  = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <=m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 저장 (하나의 간선 입력받을 때 다른 방향도 같이 저장)
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);

    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < graph.get(v).size(); i++) {
            // 방문하지 않은 곳을 방문하기
            if (!visited[graph.get(v).get(i)]) {
                dfs(graph.get(v).get(i));
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}

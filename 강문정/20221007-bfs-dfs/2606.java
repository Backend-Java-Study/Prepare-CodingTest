import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        boolean[] check = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        check[1] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i <= n; i++) {
                if (arr[v][i] == 1 && !check[i]) {
                    check[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

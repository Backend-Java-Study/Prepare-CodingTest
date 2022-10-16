import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int [] human = new int[m + 1];
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                human[x] = y;
            }
            int sum = 1;
            int min_y = human[1];
            for (int j = 2; j <= m; j++){
                if (min_y > human[j]){
                    sum++;
                    min_y = human[j];
                }
            }
            System.out.println(sum);
        }
    }
}

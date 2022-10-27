import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] info;
    public static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        info = new int[n + 2][3];
        dp = new int[n + 2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp 연산
        /*
        임의의 회의 K(1≤ K ≤ N)는 회의 K − 1과 회의 K + 1과는 회의 시간이 겹치고 다른 회의들과는 회의 시간이 겹치지 않는다.
        회의가 3개 있다면 첫번째 회의와 세번째 회의는 시간이 겹치지 않음 - 효율적이려면 1, 3번 회의 인원수 더하면 됨
         */

        dp[0] = info[0][2]; // 첫 번째 회의 인원
        dp[1] = info[1][2]; // 두 번째 회의 인원
        dp[2] = info[0][2] + info[2][2];

        // 그 다음부터는 이전의 회의 중에 연속되지 않은 (2 또는 3타임 이전) 회의 중에 인원 수가 많은 걸 더해줌
        for (int i = 3; i < n; i++) {
            dp[i] = info[i][2];
            dp[i] += Math.max(dp[i - 2], dp[i - 3]);
        }

        if(n < 2) {
            System.out.println(dp[n - 1]);
        } else {
            System.out.println(Math.max(dp[n - 1], dp[n - 2])); // n은 2이상인 경우는 dp[n-1] 과 dp[n-2] 중 인원이 더 큰 것이 효율적인 경우
        }
    }
}

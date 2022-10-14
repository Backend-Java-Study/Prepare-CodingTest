import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 서류, 면접의 순위를 입력받음
    /*
    서류 등수 기준으로 정렬하고 서류 1등의 면접 순위를 기준으로 정하기
    매번 면접 등수를 기준값으로 바꿔주기
     */

    static int t;   // 테스트케이스 수
    static int cnt; // 서류 등수

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());    // 사람 수
            int[] arr = new int[n+1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b; // 서류등수를 기준으로 정렬하기 때문에 1 4 인 경우 -> arr[1] = 4
            }

            cnt = 1;    // 서류가 1등이면 무조건 입사 가능하니까 서류 1위부터 시작
            int min = arr[1];   // 기준이 되는 면접 등수
            for (int i = 2; i <= n; i++) {
                if (min > arr[i]) {
                    cnt++;
                    min = arr[i];
                }
            }
            System.out.println(cnt);
        }
    }
}

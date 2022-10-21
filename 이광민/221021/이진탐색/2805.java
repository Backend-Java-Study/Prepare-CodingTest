import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        long [] arr = new long[x];

        long start = 0;
        long end = 0;

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < x; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (end < arr[i]){
                end = arr[i];
            }
        }
        long result = 0;
        while (start <= end){
            long sum = 0;
            long mid = (start + end) / 2;
            for (long i : arr){
                if (i > mid){
                    sum += i - mid;
                }
            }
            if (sum < y){
               end = mid - 1;
            }
            else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
